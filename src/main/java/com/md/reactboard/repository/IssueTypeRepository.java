package com.md.reactboard.repository;


import com.md.reactboard.domain.IssueType;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IssueTypeRepository extends CrudRepository<IssueType, Long> {
    Optional<IssueType> findOneById(Long id);

    @Modifying
    Optional<IssueType> deleteOneById(Long id);
}
