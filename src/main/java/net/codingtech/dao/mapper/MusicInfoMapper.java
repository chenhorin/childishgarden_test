package net.codingtech.dao.mapper;

import net.codingtech.pojo.MusicInfo;

public interface MusicInfoMapper {
    int deleteByPrimaryKey(String musicId);

    int insert(MusicInfo record);

    int insertSelective(MusicInfo record);

    MusicInfo selectByPrimaryKey(String musicId);

    int updateByPrimaryKeySelective(MusicInfo record);

    int updateByPrimaryKey(MusicInfo record);
}