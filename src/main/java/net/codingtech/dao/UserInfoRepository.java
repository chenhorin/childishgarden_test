package net.codingtech.dao;

import net.codingtech.pojo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @program: childishgarden_test
 * @description: 用户信息表
 * @author: hongren
 * @create: 2018-08-13 16:41
 **/
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {
    List<UserInfo> findByCampId(Integer campId);
}
