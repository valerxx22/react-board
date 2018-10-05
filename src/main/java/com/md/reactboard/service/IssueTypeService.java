package com.md.reactboard.service;


import com.md.reactboard.domain.IssueType;
import com.md.reactboard.web.rest.resource.IssueTypeResource;

import java.util.List;
import java.util.Optional;

public interface IssueTypeService {

    Optional<IssueType> findOne(Long id);

    List<IssueType> findAll();

    IssueType create(IssueTypeResource resource);

    Optional<IssueType> update(Long id, IssueTypeResource resource);

    Optional<IssueType> delete(Long id);
}
