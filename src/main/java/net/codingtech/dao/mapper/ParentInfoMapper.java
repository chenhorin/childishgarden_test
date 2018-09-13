package net.codingtech.dao.mapper;

import net.codingtech.pojo.ParentInfo;

public interface ParentInfoMapper {
    int deleteByPrimaryKey(String parentId);

    int insert(ParentInfo record);

    int insertSelective(ParentInfo record);

    ParentInfo selectByPrimaryKey(String parentId);

    int updateByPrimaryKeySelective(ParentInfo record);

    int updateByPrimaryKey(ParentInfo record);
}