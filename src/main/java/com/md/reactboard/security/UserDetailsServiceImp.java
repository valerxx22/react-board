package com.md.reactboard.security;

import com.md.reactboard.domain.User;
import com.md.reactboard.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(UserDetailsServiceImp.class);

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("Authenticating {}", username);
        String lowercaseUsername = username.toLowerCase();
        Optional<User> userFromDatabase = userRepository.findOneByUserName(lowercaseUsername);

        return userFromDatabase.map(user -> {
            if (!user.getEnabled()) {
                throw new UserNotEnabledException("User " + lowercaseUsername + " was not enabled");
            }
            List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream().collect(Collectors.toList());
            return new org.springframework.security.core.userdetails.User(lowercaseUsername,
                    user.getPassword(),
                    grantedAuthorities);
        }).orElseThrow(() -> new UsernameNotFoundException("User " + lowercaseUsername + " was not found in the " +
                "database"));
    }

}
