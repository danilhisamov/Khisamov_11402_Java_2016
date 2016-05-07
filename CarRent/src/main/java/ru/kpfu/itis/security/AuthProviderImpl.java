package ru.kpfu.itis.security;

import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.kpfu.itis.entity.UserEntity;
import ru.kpfu.itis.repository.ClientRepository;
import ru.kpfu.itis.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class AuthProviderImpl implements AuthenticationProvider {
    @Qualifier("userRepository")
    @Autowired
    UserRepository userRepository;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String login = authentication.getName();
        UserEntity  user = userRepository.findOneByLogin(login);

        if (user == null){
            throw new UsernameNotFoundException("user not found");
        }

        String password = authentication.getCredentials().toString();

        if (user != null && user.getPassword() != null){
            if (!encoder.matches(password, user.getPassword())) {
                System.out.println("incorrect passwd");
                throw new BadCredentialsException("invalid password");
            }
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        if (user != null) {
            authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
        }

        UsernamePasswordAuthenticationToken person = null;

        if (user != null) {
            person = new UsernamePasswordAuthenticationToken(user, null, authorities);
        }

        return person;
    }

    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
