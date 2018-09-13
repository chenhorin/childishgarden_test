package net.codingtech.service;

import net.codingtech.VO.CurriculumCategoryTreeVO;
import net.codingtech.pojo.CurriculumCategory;

import java.util.List;

/**
 * @program: childishgarden_test
 * @description: 课程分类服务规范, 分类管理
 * @author: hongren
 **/
public interface ICurriculumCategoryService {

    /**
     * 添加分类
     * @param curriculumCategory
     * @return
     */
    CurriculumCategory addCategory(CurriculumCategory curriculumCategory);

    /**
     * 更新分类
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
     * 查看所有子节点
     *
     * @return
     */
    List<CurriculumCategory> findAllSonCategory();

    /**
     * 查看父类目下的平行分类
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


    //前后台新建更新时选择元素,如果是最底层叶子节点就返回元素,跟查询平行的子节点作用不同,前者的目的是查询元素,当是父节点时返回分类
    // ,后者是查询分类
    List<CurriculumCategoryTreeVO> findCurriculumCategoryElement(Integer parentId);

    //不返回元素
    List<CurriculumCategoryTreeVO> findCurriculumCategoryList(Integer parentId);
}
