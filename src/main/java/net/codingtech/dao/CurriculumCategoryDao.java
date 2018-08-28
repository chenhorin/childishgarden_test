package net.codingtech.dao;

import net.codingtech.dataobject.CurriculumCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: childishgarden_test
 * @description: 课程分类dao
 * @author: hongren
 * @create: 2018-08-13 15:23
 **/
public interface CurriculumCategoryDao extends JpaRepository<CurriculumCategory, Integer> {

    List<CurriculumCategory> findByParentId(Integer id);

    List<CurriculumCategory> findByIsParent(Integer id);

}
