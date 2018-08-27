package net.codingtech.service;

import net.codingtech.VO.CurriculumCategoryTreeVO;
import net.codingtech.dataobject.CurriculumCategory;

import java.util.List;

/**
 * @program: childishgarden_test
 * @description: 课程分类服务规范,分类管理
 * @author: hongren
 **/
public interface CurriculumCategoryService {

    /**
     * 查询单个类目情况
     * @param categoryId
     * @return
     */
    CurriculumCategory findOne(Integer categoryId);

    /**
     * 查看所有类目,后台查看
     * @return
     */
    List<CurriculumCategory> findAll();

    /**
     * 查看底层类目
     * @return
     */
    List<CurriculumCategory> findAllSonCategory();

    /**
     * 查看父类目下的分类,方便分类树状打开
     * @param parentId
     * @return
     */
    List<CurriculumCategory> findByParentId(Integer parentId);

    /**
     * 新增和修改分类
     * @param curriculumCategory
     * @return
     */
    CurriculumCategory save(CurriculumCategory curriculumCategory);


}
