package net.codingtech.dao;

import net.codingtech.pojo.SchoolCampInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: childishgarden_test
 * @description: 校区信息dao
 * @author: hongren
 * @create: 2018-08-13 16:38
 **/
public interface SchoolCampInfoRepository extends JpaRepository<SchoolCampInfo,Integer> {
}
