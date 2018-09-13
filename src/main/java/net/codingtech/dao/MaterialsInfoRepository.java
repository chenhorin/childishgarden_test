package net.codingtech.dao;

import net.codingtech.pojo.MaterialsInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: childishgarden_test
 * @description: 材料信息dao
 * @author: hongren
 * @create: 2018-08-13 16:34
 **/
public interface MaterialsInfoRepository extends JpaRepository<MaterialsInfo,String> {
}
