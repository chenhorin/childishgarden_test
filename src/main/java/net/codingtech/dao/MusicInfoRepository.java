package net.codingtech.dao;

import net.codingtech.pojo.MusicInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: childishgarden_test
 * @description: 音乐信息dao
 * @author: hongren
 * @create: 2018-08-13 16:36
 **/
public interface MusicInfoRepository extends JpaRepository<MusicInfo,String> {
}
