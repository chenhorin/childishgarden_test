package net.codingtech.dao;

import net.codingtech.dataobject.CurriculumInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: childishgarden_test
 * @description: 课程dao
 * @author: hongren
 * @create: 2018-08-13 16:24
 **/
public interface CurriculumInfoDao extends JpaRepository<CurriculumInfo, String> {

    List<CurriculumInfo> findByCategoryId(Integer categoryId);

}
