package net.codingtech.dao;

import net.codingtech.pojo.MaterialsCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: childishgarden_test
 * @description: 材料分类dao
 * @author: hongren
 * @create: 2018-08-13 16:34
 **/
public interface MaterialsCategoryRepository extends JpaRepository<MaterialsCategory,Integer> {
}
