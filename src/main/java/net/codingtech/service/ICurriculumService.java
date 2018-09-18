package net.codingtech.service;

import com.github.pagehelper.PageInfo;
import net.codingtech.VO.CurriculumDetailVO;
import net.codingtech.dto.CurriculumDTO;
import net.codingtech.dto.DynamicConditionDTO;
import net.codingtech.pojo.CurriculumInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @description: 课程服务
 * @author: hongren
 **/
public interface ICurriculumService {


    /**
     * 前台课程的查询接口,
     * 按条件筛选,按课程的性质，课程适合年龄
     * 关键字搜索,
     * 动态排序功能,按前台约定条件排序
     * 分页
     *
     * @param keyword
     * @param categoryId
     * @param pageNum
     * @param pageSize
     * @param orderBy
     * @param curriculumProperty
     * @param curriculumAge
     * @return
     */
    PageInfo findCurriculumByKeywordCategoryIdPropertyAge(String keyword,
                                                          Integer categoryId,
                                                          Integer pageNum,
                                                          Integer pageSize,
                                                          String orderBy,
                                                          Integer curriculumProperty,
                                                          String curriculumAge);

//    //根据动态条件查询
//    List<CurriculumDynamicVO> getByDynamicCondition(DynamicConditionDTO dynamicConditionDTO);

    /**
     * 根据校区查询老师列表
     */
    List<DynamicConditionDTO> findTeacherList(String campId);

    /**
     * 查询适合课程的年龄段
     *
     * @return
     */
    List<DynamicConditionDTO> findCurriculumAge();
/*******************************************后台服务*******************************************************************/

    /**
     * 后台详情查询
     *
     * @param curriculumId
     * @return
     */
    CurriculumDetailVO manageCurriculumDetail(String curriculumId);

    /**
     * 后台查询所有课程
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo manageFindCurriculumList(int pageNum, int pageSize);

    /**
     * 后台模糊搜索课程
     *
     * @param curriculumName
     * @param curriculumId
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo manageFindSearchCurriculum(String curriculumName,
                                        String curriculumId,
                                        int pageNum,
                                        int pageSize);

    /**
     * 课程上线
     *
     * @param curriculumId
     * @return
     */
    CurriculumInfo onUsing(String curriculumId);

    /**
     * 课程下线
     *
     * @param curriculumId
     * @return
     */
    CurriculumInfo offUsing(String curriculumId);

/*******************************************共用服务*******************************************************************/

    /**
     * 课程的修改和创建
     *
     * @param curriculumDTO
     * @return
     */
    CurriculumDTO save(CurriculumDTO curriculumDTO);

    /**
     * 查询单个课程,需要单个验证,服务都需要
     *
     * @param curriculumId
     * @return
     */
    CurriculumDTO findOne(String curriculumId);

    /**
     * 查询上线的课程,需要分页
     *
     * @return
     */
    Page<CurriculumDTO> findUpAll(Pageable pageable);

    /**
     * 查询所有课程已分页,后台
     *
     * @param pageable
     * @return
     */
    Page<CurriculumDTO> findList(Pageable pageable);

    /**
     * 根据课程分类ID,属性(室内外),适合课程动态分页查询,已倒序
     *
     * @param curriculumDTO
     * @param pageable
     * @return
     */
    Page<CurriculumDTO> findByDynamicCases(CurriculumDTO curriculumDTO, Pageable pageable);
}
