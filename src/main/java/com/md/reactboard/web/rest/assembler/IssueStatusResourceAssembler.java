package com.md.reactboard.web.rest.assembler;

import com.md.reactboard.domain.IssueStatus;
import com.md.reactboard.web.rest.controller.IssueStatusResourceController;
import com.md.reactboard.web.rest.resource.IssueStatusResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;


@Component
public class IssueStatusResourceAssembler extends ResourceAssemblerSupport<IssueStatus, IssueStatusResource> {

    public IssueStatusResourceAssembler() {
        super(IssueStatusResourceController.class, IssueStatusResource.class);
    }

    @Override
    public IssueStatusResource toResource(IssueStatus entity) {
        IssueStatusResource resource = createResourceWithId(entity.getId(), entity);
        return resource;
    }

    @Override
    protected IssueStatusResource instantiateResource(IssueStatus entity) {
        IssueStatusResource resource = new IssueStatusResource();
        resource.setName(entity.getName());
        resource.setDescription(entity.getDescription());
        resource.setCreatedDate(entity.getCreatedDate());
        resource.setLastModifiedDate(entity.getLastModifiedDate());
        return resource;
    }
}
