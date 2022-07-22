package security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import security.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    public Member findByUsername(String username);
}
