package com.md.reactboard.repository;


import com.md.reactboard.domain.Authority;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthorityRepository extends CrudRepository<Authority, Long> {

    Optional<Authority> findOneById(Long id);

    Optional<Authority> findOneByName(String name);
}
