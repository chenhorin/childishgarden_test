package net.codingtech.dao.mapper;

import net.codingtech.pojo.CurriculumCategory;

public interface CurriculumCategoryMapper {
    int deleteByPrimaryKey(Integer categoryId);

    int insert(CurriculumCategory record);

    int insertSelective(CurriculumCategory record);

    CurriculumCategory selectByPrimaryKey(Integer categoryId);

    int updateByPrimaryKeySelective(CurriculumCategory record);

    int updateByPrimaryKey(CurriculumCategory record);
}