package net.codingtech.dao.mapper;

import net.codingtech.pojo.MaterialsCategory;

public interface MaterialsCategoryMapper {
    int deleteByPrimaryKey(Integer categoryId);

    int insert(MaterialsCategory record);

    int insertSelective(MaterialsCategory record);

    MaterialsCategory selectByPrimaryKey(Integer categoryId);

    int updateByPrimaryKeySelective(MaterialsCategory record);

    int updateByPrimaryKey(MaterialsCategory record);
}