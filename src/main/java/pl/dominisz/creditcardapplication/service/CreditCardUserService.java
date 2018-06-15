package pl.dominisz.creditcardapplication.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * http://dominisz.pl
 * 14.06.2018
 */
@Service
public class CreditCardUserService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return User.withDefaultPasswordEncoder()
                .username(username)
                .password("password")
                .roles("USER")
                .build();
    }

}
