package net.codingtech.service;

import net.codingtech.pojo.CurriculumCategory;

import java.util.List;

/**
 * @program: childishgarden_test
 * @description: 课程分类服务规范, 分类管理
 * @author: hongren
 **/
public interface ICurriculumCategoryService {

    /**
     * 添加商品
     * @param curriculumCategory
     * @return
     */
    CurriculumCategory addCategory(CurriculumCategory curriculumCategory);

    /**
     * 更新商品
     * @param curriculumCategory
     * @return
     */
    CurriculumCategory updateCategory(CurriculumCategory curriculumCategory);
    /**
     * 查询单个类目情况
     *
     * @param categoryId
     * @return
     */
    CurriculumCategory findOne(Integer categoryId);

    /**
     * 查看所有类目,后台查看
     *
     * @return
     */
    List<CurriculumCategory> findAll();

    /**
     * 查看底层类目
     *
     * @return
     */
    List<CurriculumCategory> findAllSonCategory();

    /**
     * 查看父类目下的分类,方便分类树状打开
     *
     * @param parentId
     * @return
     */
    List<CurriculumCategory> findByParentId(Integer parentId);

    /**
     * 递归查询本节点的id及孩子节点的id
     * @param categoryId
     * @return
     */
    List<Integer> getCategoryAndDeepChildrenCategory(Integer categoryId);

    /**
     * 上线类目
     *
     * @param categoryId
     * @return
     */
    CurriculumCategory onUsing(Integer categoryId);

    /**
     * 下线类目
     *
     * @param categoryId
     * @return
     */
    CurriculumCategory offUsing(Integer categoryId);



}
