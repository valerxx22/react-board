package com.md.reactboard.service;


import com.md.reactboard.domain.WorkLog;
import com.md.reactboard.web.rest.resource.WorkLogResource;

import java.util.List;
import java.util.Optional;

public interface WorkLogService {

    Optional<WorkLog> findOne(Long id);

    List<WorkLog> findAll();

    List<WorkLog> findAllByIssue(String projectKey, Long idInProject);

    List<WorkLog> findAllByIssue(String key);

    WorkLog create(WorkLogResource resource);

    Optional<WorkLog> update(Long id, WorkLogResource resource);

    Optional<WorkLog> delete(Long id);
}
