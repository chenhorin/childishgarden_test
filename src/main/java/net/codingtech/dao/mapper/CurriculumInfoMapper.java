package net.codingtech.dao.mapper;

import net.codingtech.pojo.CurriculumInfo;
import org.apache.ibatis.annotations.Param;

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
    List<CurriculumInfo> selectByNameAndCurriculumId(@Param("curriculumName")String curriculumName, @Param("curriculumId") String curriculumId);

    List<CurriculumInfo> selectByNameAndCategoryIds(@Param("curriculumName")String curriculumName,@Param("categoryIdList")List<Integer> categoryIdList,
                                                    @Param("curriculumProperty")Integer curriculumProperty,@Param("curriculumAge")String curriculumAge );
}