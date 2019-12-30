package br.com.cassiamani.oauth2.service;

import br.com.cassiamani.oauth2.domain.Users;
import br.com.cassiamani.oauth2.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersRepository.findByEmail(username);

        if (users == null) {
            throw new UsernameNotFoundException(String.format("Usuário não encontrado: " + username));
        }

        return null;
    }
}
