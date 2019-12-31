package br.com.cassiamani.oauth2.config;

import br.com.cassiamani.oauth2.domain.UserRoles;
import br.com.cassiamani.oauth2.domain.Users;
import br.com.cassiamani.oauth2.domain.constants.UserRolesConstants;
import br.com.cassiamani.oauth2.repository.UserRolesRepository;
import br.com.cassiamani.oauth2.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    UserRolesRepository userRolesRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        List<Users> users = usersRepository.findAll();

        if (users.isEmpty()) {
            createUser("Administrador", "admin@admin.com.br", passwordEncoder.encode("123456"), UserRolesConstants.ROLE_ADMIN);
            createUser("Client", "client@client.com.br", passwordEncoder.encode("123456"), UserRolesConstants.ROLE_CLIENT);
        }
    }

    public void createUser(String name, String email, String password, String roleName) {

        UserRoles role = new UserRoles(roleName);

        this.userRolesRepository.save(role);
        Users user = new Users(name, email, password, Arrays.asList(role));

        usersRepository.save(user);
    }
}
