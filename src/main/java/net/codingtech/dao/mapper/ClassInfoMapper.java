package net.codingtech.dao.mapper;

import net.codingtech.pojo.ClassInfo;

public interface ClassInfoMapper {
    int deleteByPrimaryKey(String classId);

    int insert(ClassInfo record);

    int insertSelective(ClassInfo record);

    ClassInfo selectByPrimaryKey(String classId);

    int updateByPrimaryKeySelective(ClassInfo record);

    int updateByPrimaryKey(ClassInfo record);
}