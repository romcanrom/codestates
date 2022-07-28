package springsecurity.jwtauthentication.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springsecurity.jwtauthentication.model.Member;
import springsecurity.jwtauthentication.repository.MemberRepository;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RestApiController {

    private final MemberRepository memberRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @GetMapping("/home")
    public String home() {
        return "<h1>home</h1>";
    }

    @PostMapping("/token")
    public String token() {
        return "<h1>token</h1>";
    }

    @PostMapping("/join")
    public String join(@RequestBody Member member) {
        //가입 시 Member에 pw를 인코딩한 값을 전달
        member.setPassword(bCryptPasswordEncoder.encode(member.getPassword()));
        member.setRoles("ROLE_USER");
        memberRepository.save(member);

        return "회원 가입 완료";
    }

    @GetMapping("/api/v1/user")
    public String user() {
        log.info("/api/v1/user 호출");
        return "<h1>user</h1>";
    }


    @GetMapping("/api/v1/admin")
    public String admin() {
        return "<h1>admin</h1>";
    }
}
