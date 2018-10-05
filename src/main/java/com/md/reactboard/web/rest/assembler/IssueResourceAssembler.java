package com.md.reactboard.web.rest.assembler;

import com.md.reactboard.domain.Issue;
import com.md.reactboard.web.rest.controller.IssueResourceController;
import com.md.reactboard.web.rest.resource.IssuePriorityResource;
import com.md.reactboard.web.rest.resource.IssueResource;
import com.md.reactboard.web.rest.resource.IssueStatusResource;
import com.md.reactboard.web.rest.resource.IssueTypeResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;


@Component
public class IssueResourceAssembler extends ResourceAssemblerSupport<Issue, IssueResource> {

    @Autowired
    private EntityLinks entityLinks;

    public IssueResourceAssembler() {
        super(IssueResourceController.class, IssueResource.class);
    }

    @Override
    public IssueResource toResource(Issue entity) {
        IssueResource resource = createResourceWithId(entity.getKey(), entity);
        resource.add(entityLinks.linkFor(IssueResource.class).slash(entity.getKey()).slash("comments").withRel("comments"));
        resource.add(entityLinks.linkFor(IssueResource.class).slash(entity.getKey()).slash("worklogs").withRel("worklogs"));
        resource.add(entityLinks.linkFor(IssuePriorityResource.class).slash(entity.getPriority().getId()).withRel("priority"));
        resource.add(entityLinks.linkFor(IssueStatusResource.class).slash(entity.getStatus().getId()).withRel("status"));
        resource.add(entityLinks.linkFor(IssueTypeResource.class).slash(entity.getType().getId()).withRel("type"));
        return resource;
    }

    @Override
    protected IssueResource instantiateResource(Issue entity) {
        IssueResource resource = new IssueResource();
        resource.setIdInProject(entity.getIdInProject());
        resource.setProject(entity.getProject().getKey());
        resource.setSummery(entity.getSummery());
        resource.setDescription(entity.getDescription());
        resource.setTimeSpent(entity.getTimeSpent());
        resource.setTimeEstimate(entity.getTimeEstimate());
        resource.setDueDate(entity.getDueDate());
        resource.setCreatedDate(entity.getCreatedDate());
        resource.setLastModifiedDate(entity.getLastModifiedDate());
        return resource;
    }
}
