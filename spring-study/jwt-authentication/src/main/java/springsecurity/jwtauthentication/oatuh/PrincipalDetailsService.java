package springsecurity.jwtauthentication.oatuh;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import springsecurity.jwtauthentication.model.Member;
import springsecurity.jwtauthentication.repository.MemberRepository;

/**
 * username을 파라미터로 받아 repository에서 Member 객체를 찾아
 * PrincipalDetails에 파라미터로 다시 넘겨 반환
 */

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member memberEntity = memberRepository.findByUsername(username);

        return new PrincipalDetails(memberEntity);

    }
}
