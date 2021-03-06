package net.codingtech.dao;

import net.codingtech.pojo.ParentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: childishgarden_test
 * @description: 家长信息dao
 * @author: hongren
 * @create: 2018-08-13 16:37
 **/
public interface ParentInfoRepository extends JpaRepository<ParentInfo,String> {
}
