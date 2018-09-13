package net.codingtech.service;

import com.github.pagehelper.PageInfo;
import net.codingtech.VO.CurriculumDetailVO;
import net.codingtech.pojo.CurriculumInfo;
import net.codingtech.dto.CurriculumDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @program: childishgarden_test
 * @description: 课程服务
 * @author: hongren
 **/
public interface ICurriculumService {

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

    /**
     * 课程的修改和创建
     *
     * @param curriculumDTO
     * @return
     */
    CurriculumDTO save(CurriculumDTO curriculumDTO);

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


    PageInfo getCurriculumList(int pageNum, int pageSize);

    PageInfo searchCurriculum(String curriculumName, Integer curriculumId, int pageNum, int pageSize);

    //前台课程查询接口,包括按条件筛选,关键字搜索,动态排序功能,分页
    PageInfo getCurriculumByKeywordCategory(String keyword, Integer categoryId, Integer pageNum,
                                         Integer pageSize, String orderBy,Integer curriculumProperty,
                                         String curriculumAge);




    //后台使用
    CurriculumDetailVO manageCurriculumDetail(String curriculumId);
}
