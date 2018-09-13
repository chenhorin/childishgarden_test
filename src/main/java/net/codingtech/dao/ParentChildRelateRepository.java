package net.codingtech.dao;

import net.codingtech.pojo.ParentChildRelate;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: childishgarden_test
 * @description: 家长关系dao
 * @author: hongren
 * @create: 2018-08-13 16:36
 **/
public interface ParentChildRelateRepository extends JpaRepository<ParentChildRelate, String> {
}
