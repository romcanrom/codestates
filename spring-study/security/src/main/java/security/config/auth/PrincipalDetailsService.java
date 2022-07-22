package security.config.auth;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import security.model.Member;
import security.repository.MemberRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class PrincipalDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    //loginProcessingUrl("/login");으로 요청 발생 시 자동 실행
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { //파라미터 username 매칭 필

        Member memberEntity = memberRepository.findByUsername(username);
        log.info("username={}", username);

        if (memberEntity != null) {
            return new PrincipalDetails(memberEntity);
        }

        return null;
    }
}
