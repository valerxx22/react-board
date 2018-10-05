package com.md.reactboard.service;


import com.md.reactboard.domain.Project;
import com.md.reactboard.web.rest.resource.ProjectResource;

import java.util.List;
import java.util.Optional;

public interface ProjectService {

    Optional<Project> findOne(Long id);

    Optional<Project> findOne(String key);

    List<Project> findAll();

    Project create(ProjectResource resource);

    Optional<Project> update(Long id, ProjectResource resource);

    Optional<Project> update(String key, ProjectResource resource);

    Optional<Project> delete(String key);
}
