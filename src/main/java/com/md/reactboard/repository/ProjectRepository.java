package com.md.reactboard.repository;


import com.md.reactboard.domain.Project;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    Optional<Project> findOneById(Long id);

    Optional<Project> findOneByKey(String key);

    @Modifying
    Optional<Project> deleteOneByKey(String key);
}
