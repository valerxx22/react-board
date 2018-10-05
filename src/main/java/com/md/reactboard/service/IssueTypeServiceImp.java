package com.md.reactboard.service;


import com.md.reactboard.domain.IssueType;
import com.md.reactboard.repository.IssueTypeRepository;
import com.md.reactboard.web.rest.resource.IssueTypeResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class IssueTypeServiceImp implements IssueTypeService {


    @Autowired
    IssueTypeRepository issueTypeRepository;


    public Optional<IssueType> findOne(Long id) {
        return issueTypeRepository.findOneById(id);
    }


    public List<IssueType> findAll() {
        return (List<IssueType>) issueTypeRepository.findAll();
    }

    @Transactional
    public IssueType create(IssueTypeResource resource) {
        IssueType issueType = new IssueType();
        issueType.setName(resource.getName());
        issueType.setDescription(resource.getDescription());
        return issueTypeRepository.save(issueType);
    }

    @Transactional
    public Optional<IssueType> update(Long id, IssueTypeResource resource) {
        return findOne(id)
            .map(entity -> {
                entity.setName(resource.getName());
                entity.setDescription(resource.getDescription());
                return issueTypeRepository.save(entity);
            });
    }

    @Transactional
    public Optional<IssueType> delete(Long id) {
        return issueTypeRepository.deleteOneById(id);
    }
}
