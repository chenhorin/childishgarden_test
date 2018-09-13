package net.codingtech.dao.mapper;

import net.codingtech.pojo.MusicCategory;

public interface MusicCategoryMapper {
    int deleteByPrimaryKey(Integer categoryId);

    int insert(MusicCategory record);

    int insertSelective(MusicCategory record);

    MusicCategory selectByPrimaryKey(Integer categoryId);

    int updateByPrimaryKeySelective(MusicCategory record);

    int updateByPrimaryKey(MusicCategory record);
}