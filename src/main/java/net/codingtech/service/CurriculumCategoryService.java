package net.codingtech.service;

import net.codingtech.VO.CurriculumCategoryTreeVO;
import net.codingtech.dataobject.CurriculumCategory;

import java.util.List;

/**
 * @program: childishgarden_test
 * @description: 课程分类服务规范
 * @author: hongren
 * @create: 2018-08-13 16:54
 **/
public interface CurriculumCategoryService {

    CurriculumCategory findOne(Integer categoryId);

    List<CurriculumCategory> findAll();

    List<CurriculumCategory> findByCategoryIdIn(List<Integer> categoryIdList);

    List<CurriculumCategoryTreeVO> findCurriculumCategoryList(Integer parentId);
}
