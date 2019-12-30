package br.com.cassiamani.oauth2.repository;

import br.com.cassiamani.oauth2.domain.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRolesRepository extends JpaRepository<UserRoles, Long> {
}
