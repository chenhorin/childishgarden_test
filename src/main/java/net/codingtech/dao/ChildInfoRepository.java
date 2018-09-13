package net.codingtech.dao;

import net.codingtech.pojo.ChildInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: childishgarden_test
 * @description: 孩子信息dao
 * @author: hongren
 * @create: 2018-08-13 16:32
 **/
public interface ChildInfoRepository extends JpaRepository<ChildInfo,String> {
}
