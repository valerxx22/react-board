package com.md.reactboard.repository;


import com.md.reactboard.domain.IssuePriority;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IssuePriorityRepository extends CrudRepository<IssuePriority, Long> {
    Optional<IssuePriority> findOneById(Long id);

    @Modifying
    Optional<IssuePriority> deleteOneById(Long id);
}
