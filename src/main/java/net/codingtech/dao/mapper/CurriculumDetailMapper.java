package net.codingtech.dao.mapper;

import net.codingtech.pojo.CurriculumDetail;

public interface CurriculumDetailMapper {
    int deleteByPrimaryKey(String detailId);

    int insert(CurriculumDetail record);

    int insertSelective(CurriculumDetail record);

    CurriculumDetail selectByPrimaryKey(String detailId);

    int updateByPrimaryKeySelective(CurriculumDetail record);

    int updateByPrimaryKey(CurriculumDetail record);
}