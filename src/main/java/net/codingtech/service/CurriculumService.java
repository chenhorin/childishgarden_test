package net.codingtech.service;

import net.codingtech.dataobject.CurriculumInfo;
import net.codingtech.dto.CurriculumDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @program: childishgarden_test
 * @description: 课程服务
 * @author: hongren
 **/
public interface CurriculumService {

    /**
     * 查询单个课程,需要单个验证,服务都需要
     * @param curriculumId
     * @return
     */
    CurriculumDTO findOne(String curriculumId);

    /**
     * 查询上线的课程,需要分页
     * @return
     */
    Page<CurriculumDTO> findUpAll(Pageable pageable);

    /**
     * 查询所有课程已分页,后台
     * @param pageable
     * @return
     */
    Page<CurriculumDTO> findList(Pageable pageable);

    /**
     * 根据课程分类ID,属性(室内外),适合课程动态分页查询,已倒序
     * @param curriculumDTO
     * @param pageable
     * @return
     */
    Page<CurriculumDTO> findByDynamicCases(CurriculumDTO curriculumDTO, Pageable pageable);

    /**
     * 课程的修改和创建
     * @param curriculumDTO
     * @return
     */
    CurriculumDTO save(CurriculumDTO curriculumDTO);

    /**
     * 课程上线
     * @param curriculumId
     * @return
     */
    CurriculumDTO onUsing(String curriculumId);

    /**
     * 课程下线
     * @param curriculumId
     * @return
     */
    CurriculumDTO offUsing(String curriculumId);





}
