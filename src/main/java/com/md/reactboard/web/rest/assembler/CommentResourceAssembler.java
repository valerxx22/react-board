package com.md.reactboard.web.rest.assembler;

import com.md.reactboard.domain.Comment;
import com.md.reactboard.web.rest.controller.CommentResourceController;
import com.md.reactboard.web.rest.resource.CommentResource;
import com.md.reactboard.web.rest.resource.IssueResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;


@Component
public class CommentResourceAssembler extends ResourceAssemblerSupport<Comment, CommentResource> {

    @Autowired
    private EntityLinks entityLinks;

    public CommentResourceAssembler() {
        super(CommentResourceController.class, CommentResource.class);
    }

    @Override
    public CommentResource toResource(Comment entity) {
        CommentResource resource = createResourceWithId(entity.getId(), entity);
        resource.add(entityLinks.linkFor(IssueResource.class).slash(entity.getIssue().getKey()).withRel("issue"));
        return resource;
    }

    @Override
    protected CommentResource instantiateResource(Comment entity) {
        CommentResource resource = new CommentResource();
        resource.setContent(entity.getContent());
        resource.setCreatedDate(entity.getCreatedDate());
        resource.setLastModifiedDate(entity.getLastModifiedDate());
        return resource;
    }
}
