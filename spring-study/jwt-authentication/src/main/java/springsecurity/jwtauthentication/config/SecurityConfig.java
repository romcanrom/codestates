package springsecurity.jwtauthentication.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.CorsFilter;
import springsecurity.jwtauthentication.filter.JwtAuthenticationFilter;
import springsecurity.jwtauthentication.filter.JwtAuthorizationFilter;
import springsecurity.jwtauthentication.repository.MemberRepository;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final CorsFilter corsFilter;
    private final MemberRepository memberRepository;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //csrf 보호 기능 X (spring security basic auth 사용)
        http.csrf().disable();

        //h2 console 사용 허용
        http.headers().frameOptions().disable();

        //필터 등록 (BasicAuthenticationFilter 실행 전에 적용되도록 설정)
        //http.addFilterBefore(new FirstFilter(), BasicAuthenticationFilter.class);

        //세션/쿠키 X, 무상태성으로 설계
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()

                //form을 통한 로그인 비활성화
                .formLogin().disable()

                //http 로그인 방식(헤더에 authorization 값을 id, pw로 입력) 사용 X
                .httpBasic().disable()

                //필터 등록
                .apply(new CustomDsl())

                .and()
                .authorizeRequests()

                .antMatchers("/api/v1/user/**")
                .access("hasRole('ROLE_USER') or hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")

                .antMatchers("/api/v1/manager/**")
                .access("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")

                .antMatchers("/api/v1/admin/**")
                .access("hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll();

        return http.build();
    }

    public class CustomDsl extends AbstractHttpConfigurer<CustomDsl, HttpSecurity> {
        @Override
        public void configure(HttpSecurity builder) throws Exception {

            AuthenticationManager authenticationManager = builder.getSharedObject(AuthenticationManager.class);

            builder
                    .addFilter(corsFilter)
                    .addFilter(new JwtAuthenticationFilter(authenticationManager))
                    .addFilter(new JwtAuthorizationFilter(authenticationManager, memberRepository));

        }
    }



}
