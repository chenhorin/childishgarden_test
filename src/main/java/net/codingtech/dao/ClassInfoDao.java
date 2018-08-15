package net.codingtech.dao;

import net.codingtech.dataobject.ClassInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: childishgarden_test
 * @description: 班级dao
 * @author: hongren
 * @create: 2018-08-13 16:33
 **/
public interface ClassInfoDao extends JpaRepository<ClassInfo,String> {
}
