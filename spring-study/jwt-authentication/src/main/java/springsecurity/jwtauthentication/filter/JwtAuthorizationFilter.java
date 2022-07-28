package springsecurity.jwtauthentication.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import springsecurity.jwtauthentication.model.Member;
import springsecurity.jwtauthentication.oatuh.PrincipalDetails;
import springsecurity.jwtauthentication.repository.MemberRepository;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * BasicAuthenticationFilter (인가)
 * Security Filter에서 권한/인증이 필요한 주소 요청 시 BasicAuthenticationFilter 적용
 */

@Slf4j
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private final MemberRepository memberRepository;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, MemberRepository memberRepository) {
        super(authenticationManager);
        this.memberRepository = memberRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("인증 혹은 권한이 필요한 페이지가 요청되었습니다");

        String jwtHeader = request.getHeader("Authorization");

        if (jwtHeader == null || !jwtHeader.startsWith("Bearer")) {
            chain.doFilter(request, response);
            return;
        }

        String jwtToken = jwtHeader.replace("Bearer ", "");

        String username = JWT
                .require(Algorithm.HMAC512("cos_jwt_token"))
                .build()
                .verify(jwtToken)
                .getClaim("username").asString();

        if (username != null) {
            Member memberEntity = memberRepository.findByUsername(username);

            PrincipalDetails principalDetails = new PrincipalDetails(memberEntity);
            log.info("principalDetails={}", principalDetails);

            Authentication authentication = new UsernamePasswordAuthenticationToken(principalDetails, null, principalDetails.getAuthorities());
            log.info("authentication={}", authentication);

            SecurityContextHolder.getContext().setAuthentication(authentication); //인증 정보 삽입

            chain.doFilter(request, response);
        }


        super.doFilterInternal(request, response, chain);
    }
}
