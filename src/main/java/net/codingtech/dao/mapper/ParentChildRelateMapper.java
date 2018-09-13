package net.codingtech.dao.mapper;

import net.codingtech.pojo.ParentChildRelate;

public interface ParentChildRelateMapper {
    int deleteByPrimaryKey(String relateId);

    int insert(ParentChildRelate record);

    int insertSelective(ParentChildRelate record);

    ParentChildRelate selectByPrimaryKey(String relateId);

    int updateByPrimaryKeySelective(ParentChildRelate record);

    int updateByPrimaryKey(ParentChildRelate record);
}