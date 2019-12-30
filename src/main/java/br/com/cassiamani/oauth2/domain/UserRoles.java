package br.com.cassiamani.oauth2.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "Roles")
public class UserRoles implements GrantedAuthority {

    public UserRoles(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long id;
    private String name;

    @Override
    public String getAuthority() {
        return this.name;
    }
}
