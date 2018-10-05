package com.reactboard.web.repository;

import com.reactboard.web.Application;
import com.reactboard.web.repository.ProjectRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional
public class ProjectRepositoryTest {

    @Autowired
    ProjectRepository projectRepository;

    @Test
    public void testFindOneByKey() {
        Assert.assertEquals("TEST", projectRepository.findOneByKey("TEST").get().getKey());
        Assert.assertEquals("BEST", projectRepository.findOneByKey("BEST").get().getKey());
        Assert.assertEquals("BEST1", projectRepository.findOneByKey("BEST1").get().getKey());
        Assert.assertEquals("ESTIMATION", projectRepository.findOneByKey("ESTIMATION").get().getKey());
        Assert.assertNull(projectRepository.findOneByKey("DEL"));
    }

    @Test
    public void testDeleteByKey(){
        Assert.assertNotNull(projectRepository.findOneByKey("TEST"));
        projectRepository.deleteOneByKey("TEST");
        Assert.assertNull(projectRepository.findOneByKey("TEST"));
    }
}
