package com.md.reactboard.service;


import com.md.reactboard.domain.IssuePriority;
import com.md.reactboard.web.rest.resource.IssuePriorityResource;

import java.util.List;
import java.util.Optional;

public interface IssuePriorityService {

    Optional<IssuePriority> findOne(Long id);

    List<IssuePriority> findAll();

    IssuePriority create(IssuePriorityResource resource);

    Optional<IssuePriority> update(Long id, IssuePriorityResource resource);

    Optional<IssuePriority> delete(Long id);
}
