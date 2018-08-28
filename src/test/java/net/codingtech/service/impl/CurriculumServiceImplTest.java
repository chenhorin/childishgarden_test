package net.codingtech.service.impl;

import net.codingtech.dataobject.CurriculumInfo;
import net.codingtech.dto.CurriculumDTO;
import net.codingtech.service.CurriculumService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurriculumServiceImplTest {

    @Autowired
    CurriculumService curriculumService;


    @Test
    public void findByCategoryId() {
    }

    @Test
    public void findByDynamicCases() {
        CurriculumDTO curriculumDTO = new CurriculumDTO();
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");
        PageRequest pageRequest = new PageRequest(0, 10, sort);
        Page<CurriculumDTO> curriculumInfoPage = curriculumService.findByDynamicCases(curriculumDTO, pageRequest);
        Assert.assertNotEquals(0, curriculumInfoPage.getTotalElements());
    }
}