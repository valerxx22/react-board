package com.md.reactboard.service;


import com.md.reactboard.domain.Comment;
import com.md.reactboard.web.rest.resource.CommentResource;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    Optional<Comment> findOne(Long id);

    List<Comment> findAll();

    List<Comment> findAllByIssue(String projectKey, Long idInProject);

    List<Comment> findAllByIssue(String key);

    Comment create(CommentResource resource);

    Optional<Comment> update(Long id, CommentResource resource);

    Optional<Comment> delete(Long id);

}
