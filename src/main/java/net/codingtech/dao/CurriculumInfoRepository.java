package net.codingtech.dao;

import net.codingtech.pojo.CurriculumInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @program: childishgarden_test
 * @description: 课程dao
 * @author: hongren
 * @create: 2018-08-13 16:24
 **/
public interface CurriculumInfoRepository extends JpaRepository<CurriculumInfo, String>, JpaSpecificationExecutor<CurriculumInfo> {

    /**
     * 按类目id查询课程
     * @param categoryId
     * @return
     */
    List<CurriculumInfo> findByCategoryId(Integer categoryId);


    /**
     * 查询所有在线的课程
     * @param curriculumStatus
     * @return
     */
    List<CurriculumInfo> findByCurriculumStatus(Integer curriculumStatus);


}
