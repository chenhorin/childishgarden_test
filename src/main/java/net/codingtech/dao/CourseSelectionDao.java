package net.codingtech.dao;

import net.codingtech.dataobject.CourseSelection;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: childishgarden_test
 * @description: 选课dao
 * @author: hongren
 * @create: 2018-08-13 16:27
 **/
public interface CourseSelectionDao extends JpaRepository<CourseSelection,String> {
}
