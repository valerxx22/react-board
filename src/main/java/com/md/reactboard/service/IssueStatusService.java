package com.md.reactboard.service;


import com.md.reactboard.domain.IssueStatus;
import com.md.reactboard.web.rest.resource.IssueStatusResource;

import java.util.List;
import java.util.Optional;

public interface IssueStatusService {

    Optional<IssueStatus> findOne(Long id);

    List<IssueStatus> findAll();

    IssueStatus create(IssueStatusResource resource);

    Optional<IssueStatus> update(Long id, IssueStatusResource resource);

    Optional<IssueStatus> delete(Long id);
}
