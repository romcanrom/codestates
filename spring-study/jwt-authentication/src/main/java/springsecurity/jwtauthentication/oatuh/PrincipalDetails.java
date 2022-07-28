package springsecurity.jwtauthentication.oatuh;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import springsecurity.jwtauthentication.model.Member;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Member 객체를 의존성 주입 받아 role, username, pw 반환 (details)
 */

@Data
public class PrincipalDetails implements UserDetails {

    private Member member;

    public PrincipalDetails(Member member) {
        this.member = member;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        Collection<GrantedAuthority> authorities = new ArrayList<>();

        //authorities에 roles를 가져와 담는 로직
        member.getRoleList().forEach(n -> {
            authorities.add(() -> n);
        });

        return authorities;
    }

    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public String getUsername() {
        return member.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
