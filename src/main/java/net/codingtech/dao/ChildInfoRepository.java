package net.codingtech.dao;

import net.codingtech.pojo.ChildInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: childishgarden_test
 * @description: 孩子信息dao
 * @author: hongren
 * @create: 2018-08-13 16:32
 **/
public interface ChildInfoRepository extends JpaRepository<ChildInfo,String> {

    //根据班级查询学生
    List<ChildInfo> findChildInfoByClassId(String classId);
}
