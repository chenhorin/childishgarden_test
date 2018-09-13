package net.codingtech.dao;

import net.codingtech.pojo.ClassInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: childishgarden_test
 * @description: 班级dao
 * @author: hongren
 * @create: 2018-08-13 16:33
 **/
public interface ClassInfoRepository extends JpaRepository<ClassInfo,String> {
}
