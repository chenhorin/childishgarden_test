package net.codingtech.dao;

import net.codingtech.dataobject.MusicCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: childishgarden_test
 * @description: 音乐分类dao
 * @author: hongren
 * @create: 2018-08-13 16:35
 **/
public interface MusicCategoryDao extends JpaRepository<MusicCategory,Integer> {
}
