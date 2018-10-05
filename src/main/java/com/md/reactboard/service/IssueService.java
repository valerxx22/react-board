package com.md.reactboard.service;


import com.md.reactboard.domain.Issue;
import com.md.reactboard.web.rest.resource.IssueResource;

import java.util.List;
import java.util.Optional;

public interface IssueService {

    Optional<Issue> findOne(Long id);

    Optional<Issue> findOne(String projectKey, Long idInProject);

    Optional<Issue> findOne(String key);

    List<Issue> findAllByProject(Long id);

    List<Issue> findAllByProject(String key);

    List<Issue> findAll();

    Issue create(IssueResource resource);

    Optional<Issue> update(String key, IssueResource resource);

    Optional<Issue> delete(Long id);

    Optional<Issue> delete(String key);

    Optional<Issue> delete(String projectKey, Long idInProject);

    Issue recalculateTimeSpent(Issue issue);
}
