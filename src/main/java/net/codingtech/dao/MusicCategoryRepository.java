package net.codingtech.dao;

import net.codingtech.pojo.MusicCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: childishgarden_test
 * @description: 音乐分类dao
 * @author: hongren
 * @create: 2018-08-13 16:35
 **/
public interface MusicCategoryRepository extends JpaRepository<MusicCategory,Integer> {
}
