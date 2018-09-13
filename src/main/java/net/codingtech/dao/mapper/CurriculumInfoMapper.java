package net.codingtech.dao.mapper;

import net.codingtech.pojo.CurriculumInfo;

import java.util.List;

public interface CurriculumInfoMapper {
    int deleteByPrimaryKey(String curriculumId);

    int insert(CurriculumInfo record);

    int insertSelective(CurriculumInfo record);

    CurriculumInfo selectByPrimaryKey(String curriculumId);

    int updateByPrimaryKeySelective(CurriculumInfo record);

    int updateByPrimaryKey(CurriculumInfo record);
    /**
     * 根据名字和id查询
     * @return
     */
    List<CurriculumInfo> selectByNameAndProductId(String curriculumName, Integer curriculumId);
}