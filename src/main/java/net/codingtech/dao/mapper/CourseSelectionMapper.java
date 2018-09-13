package net.codingtech.dao.mapper;

import net.codingtech.pojo.CourseSelection;

public interface CourseSelectionMapper {
    int deleteByPrimaryKey(String detailId);

    int insert(CourseSelection record);

    int insertSelective(CourseSelection record);

    CourseSelection selectByPrimaryKey(String detailId);

    int updateByPrimaryKeySelective(CourseSelection record);

    int updateByPrimaryKey(CourseSelection record);
}