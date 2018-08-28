package net.codingtech.dao;

import net.codingtech.dataobject.CurriculumDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: childishgarden_test
 * @description: 课程详情dao
 * @author: hongren
 * @create: 2018-08-13 16:25
 **/
public interface CurriculumDetailDao extends JpaRepository<CurriculumDetail, String> {

    /**
     * 按课程id查询详情List
     */
    List<CurriculumDetail> findByCurriculumId(String curriculumId);
}
