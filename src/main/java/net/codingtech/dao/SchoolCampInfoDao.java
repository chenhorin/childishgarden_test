package net.codingtech.dao;

import net.codingtech.dataobject.SchoolCampInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: childishgarden_test
 * @description: 校区信息dao
 * @author: hongren
 * @create: 2018-08-13 16:38
 **/
public interface SchoolCampInfoDao extends JpaRepository<SchoolCampInfo,Integer> {
}
