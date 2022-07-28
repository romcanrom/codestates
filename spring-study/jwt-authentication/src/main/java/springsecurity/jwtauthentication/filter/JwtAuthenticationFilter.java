package springsecurity.jwtauthentication.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import springsecurity.jwtauthentication.model.Member;
import springsecurity.jwtauthentication.oatuh.PrincipalDetails;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;

/**
 * UsernamePasswordAuthenticationFilter (인증)
 */
@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    //jwt 인증 필터가 인증 매니저에 의존
    private final AuthenticationManager authenticationManager;


    //로그인 처리
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        log.info("login 시도: request={}, response={}", request, response);
/*
        HeaderWriterFilter$HeaderWriterRequest, HeaderWriterFilter$HeaderWriterResponse
*/

        try {

            ObjectMapper mapper = new ObjectMapper();
            //request.getInputStream() -> HTTP 본문의 컨텐츠를 가져오기
            //가져온 본문(json)을 Member 타입으로 매핑
            Member member = mapper.readValue(request.getInputStream(), Member.class);
            log.info("member={}", member);
/*
            member=Member(id=null, username=arom, password=1234, roles=null)
*/

            //Member에서 username, password를 가져와 토큰 생성
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(member.getUsername(), member.getPassword());
            log.info("token={}", authenticationToken);
/*
            token=UsernamePasswordAuthenticationToken [Principal=arom, Credentials=[PROTECTED], Authenticated=false, Details=null, Granted Authorities=[]]
*/

            //토큰 인증 시도, 성공 시 fully populated 인증 객체 반환
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            log.info("authentication={}", authentication);
/*
            authentication=UsernamePasswordAuthenticationToken

             [Principal=PrincipalDetails(
             member=Member(id=1, username=arom, password=$2a$10$Ul43ofJ/dapR72XRo4qVU.w7XfUSb2Id1SOSxjCasYz/ViiLJ9q76, roles=ROLE_USER)),

             Credentials=[PROTECTED],
             Authenticated=true,
             Details=null,
             Granted Authorities=[springsecurity.jwtauthentication.oatuh.PrincipalDetails$$Lambda$1253/0x00000008008e4040@5ec609a]]
*/

            return authentication;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        log.info("successfulAuthentication 호출");

        PrincipalDetails principalDetails = (PrincipalDetails) authResult.getPrincipal();
        log.info("principalDetails={}", principalDetails);
/*
        principalDetails=PrincipalDetails(member=Member(id=1, username=arom, password=$2a$10$ui5DBiv8AgqTryQ.jc6W0OapXVDCT5MjwWgLYbofxQqgS0eOP4wRu, roles=ROLE_USER))
  */

        String jwtToken = JWT.create()
                .withSubject("cos jwt token")
                .withExpiresAt(new Date(System.currentTimeMillis() + (60 * 1000 * 10)))
                .withClaim("id", principalDetails.getMember().getId())
                .withClaim("username", principalDetails.getMember().getUsername())
                .sign(Algorithm.HMAC512("cos_jwt_token"));

        response.addHeader("Authorization", "Bearer " + jwtToken);

    }

    //V0 - 로그 출력, request, response로 Authentication 객체 반환
    public Authentication attemptAuthenticationV0(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        log.info("login 시도: request={}, response={}", request, response);

        return super.attemptAuthentication(request, response);
        //초기 코드

        /**
         * super.attemptAuthentication(request, response)
         *
         * 1. request에서 username과 password를 얻어온다
         *      String username = obtainUsername(request);
         * 		username = (username != null) ? username.trim() : "";
         * 		String password = obtainPassword(request);
         * 		password = (password != null) ? password : "";
         *
         * 2. UsernamePasswordAuthenticationToken.unauthenticated(username,password) 호출
         *  - username, password를 파라미터로 받아 인증되지 않은 토큰 생성
         *      UsernamePasswordAuthenticationToken authRequest =
         *  	UsernamePasswordAuthenticationToken.unauthenticated(username, password);
         *
         * 3. setDetails(request, authRequest) 호출
         *  - 인증 요청의 details property 속성에 넣을 내용 구성
         *  - 내용: request, (username, password)로 만든 토큰(authRequest)
         *
         * 4. getAuthenticationManager().authenticate(authRequest) 반환
         *  - 인증?
         *
         *
         * postOnly == true, 요청 메서드 != POST -> 예외 발생
         */

    }

    //V1 - 사용자 정보 확인
    public Authentication attemptAuthenticationV1(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        log.info("login 시도: request={}, response={}", request, response);

        try {

            //request의 정보를 가져와서 출력

            BufferedReader br = request.getReader();

            String input = null;
            while ((input = br.readLine()) != null) {
                log.info("input={}", input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.attemptAuthentication(request, response);
    }
    }
