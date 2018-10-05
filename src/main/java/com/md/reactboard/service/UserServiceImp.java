package com.md.reactboard.service;


import com.md.reactboard.domain.Authority;
import com.md.reactboard.domain.User;
import com.md.reactboard.repository.AuthorityRepository;
import com.md.reactboard.repository.UserRepository;
import com.md.reactboard.security.SecurityUtils;
import com.md.reactboard.service.util.RandomUtil;
import com.md.reactboard.web.rest.resource.UserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthorityRepository authorityRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional
    public User create(UserResource resource) {
        User user = new User();
        user.setUserName(resource.getUserName());
        user.setEmail(resource.getEmail());
        user.setEnabled(resource.getEnabled());
        user.setPassword(passwordEncoder.encode(RandomUtil.generatePassword()));

        Set<Authority> authorities = new HashSet<>();
        resource.getAuthorities().stream().forEach(authority -> authorityRepository.findOneByName(authority).map(authorities::add));
        user.setAuthorities(authorities);

        return userRepository.save(user);
    }

    @Transactional
    public Optional<User> update(String userName, UserResource resource) {
        return userRepository.findOneByUserName(userName)
            .map(entity -> {
                entity.setEmail(resource.getEmail());
                entity.setEnabled(resource.getEnabled());
                Set<Authority> authorities = new HashSet<>();
                resource.getAuthorities().stream().forEach(authority -> authorityRepository.findOneByName(authority).map(authorities::add));
                entity.setAuthorities(authorities);
                return userRepository.save(entity);
            });
    }

    public Optional<User> findOneByUserName(String username) {
        return userRepository.findOneByUserName(username);
    }

    public Optional<User> findOneByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    public Optional<User> getUser() {
        return userRepository.findOneByUserName(SecurityUtils.getCurrentUserName());
    }

    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Transactional
    public Optional<User> delete(String userName) {
        return userRepository.deleteByUserName(userName);
    }
}
