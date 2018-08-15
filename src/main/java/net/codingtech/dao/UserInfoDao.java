package net.codingtech.dao;

import net.codingtech.dataobject.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: childishgarden_test
 * @description: 用户信息表
 * @author: hongren
 * @create: 2018-08-13 16:41
 **/
public interface UserInfoDao extends JpaRepository<UserInfo,String> {
}
