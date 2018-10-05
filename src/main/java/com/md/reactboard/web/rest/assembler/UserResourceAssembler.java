package com.md.reactboard.web.rest.assembler;

import com.md.reactboard.domain.User;
import com.md.reactboard.web.rest.controller.UserResourceController;
import com.md.reactboard.web.rest.resource.UserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;


@Component
public class UserResourceAssembler extends ResourceAssemblerSupport<User, UserResource> {

    @Autowired
    private EntityLinks entityLinks;

    public UserResourceAssembler() {
        super(UserResourceController.class, UserResource.class);
    }

    @Override
    public UserResource toResource(User entity) {
        UserResource resource = createResourceWithId(entity.getUserName(), entity);
        resource.add(entityLinks.linkFor(UserResource.class).slash(entity.getUserName()).slash("authorities").withRel("authorities"));
        return resource;
    }

    @Override
    protected UserResource instantiateResource(User entity) {
        UserResource resource = new UserResource();
        resource.setUserName(entity.getUserName());
        resource.setEmail(entity.getEmail());
        resource.setCreatedDate(entity.getCreatedDate());
        resource.setLastModifiedDate(entity.getLastModifiedDate());
        return resource;
    }
}
