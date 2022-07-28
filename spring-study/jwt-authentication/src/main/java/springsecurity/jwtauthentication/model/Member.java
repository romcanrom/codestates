package springsecurity.jwtauthentication.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String roles; //ROLE_USER, ROLE_MANAGER, ROLE_ADMIN

    public List<String> getRoleList() {
        if (this.roles.length() > 0) {
            return Arrays.asList(roles.split(","));
        }
        return new ArrayList<>();
    }
}
