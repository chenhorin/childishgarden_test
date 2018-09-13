package net.codingtech.dao.mapper;

import net.codingtech.pojo.ChildInfo;

public interface ChildInfoMapper {
    int deleteByPrimaryKey(String childId);

    int insert(ChildInfo record);

    int insertSelective(ChildInfo record);

    ChildInfo selectByPrimaryKey(String childId);

    int updateByPrimaryKeySelective(ChildInfo record);

    int updateByPrimaryKey(ChildInfo record);
}