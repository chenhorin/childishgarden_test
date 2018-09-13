package net.codingtech.service.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import net.codingtech.VO.CurriculumCategoryTreeVO;
import net.codingtech.common.enums.CurriculumCategoryEnum;
import net.codingtech.common.enums.ResultEnum;
import net.codingtech.dao.CurriculumCategoryRepository;
import net.codingtech.pojo.CurriculumCategory;
import net.codingtech.exception.CurriculumException;
import net.codingtech.service.ICurriculumCategoryService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @program: childishgarden_test
 * @description: 分类服务的实现类
 * @author: hongren
 * @create: 2018-08-14 16:08
 **/
@Service
public class CurriculumCategoryServiceImpl implements ICurriculumCategoryService {

    @Autowired
    CurriculumCategoryRepository curriculumCategoryDao;


    @Override
    public CurriculumCategory addCategory(CurriculumCategory curriculumCategory) {
        if (curriculumCategory.getParentId() == null || StringUtils.isBlank(curriculumCategory.getCategoryName())) {
            throw new CurriculumException(ResultEnum.CURRICULUM_CATEGORY_ADD_ERROR);
        }

        CurriculumCategory category = curriculumCategoryDao.save(curriculumCategory);

        return category;
    }

    @Override
    public CurriculumCategory updateCategory(CurriculumCategory curriculumCategory) {
        if (curriculumCategory.getCategoryId() == null || StringUtils.isBlank(curriculumCategory.getCategoryName())) {
            throw new CurriculumException(ResultEnum.CURRICULUM_CATEGORY_ADD_ERROR);
        }

        CurriculumCategory category = curriculumCategoryDao.save(curriculumCategory);
        return category;
    }

    @Override
    public CurriculumCategory findOne(Integer categoryId) {
        return curriculumCategoryDao.findOne(categoryId);
    }

    @Override
    public List<CurriculumCategory> findAll() {
        return curriculumCategoryDao.findAll();
    }

    @Override
    public List<CurriculumCategory> findAllSonCategory() {
        List<CurriculumCategory> curriculumCategoryList = curriculumCategoryDao.
                findByIsParent(CurriculumCategoryEnum.SON_DOT.getCode());
        if (CollectionUtils.isEmpty(curriculumCategoryList)) {
            throw new CurriculumException(ResultEnum.CURRICULUM_CATEGORY_NOT_EXIST);
        }
        return curriculumCategoryList;
    }

    @Override
    public List<CurriculumCategory> findByParentId(Integer parentId) {
        List<CurriculumCategory> categoryList = curriculumCategoryDao.findByParentId(parentId);
        if (CollectionUtils.isEmpty(categoryList)) {
            throw new CurriculumException(ResultEnum.CURRICULUM_CATEGORY_NOT_EXIST);
        }
        return categoryList;
    }


    @Override
    public CurriculumCategory onUsing(Integer categoryId) {
        CurriculumCategory curriculumCategory = curriculumCategoryDao.findOne(categoryId);
        //非空判断
        if (curriculumCategory == null) {
            throw new CurriculumException(ResultEnum.CURRICULUM_CATEGORY_NOT_EXIST);
        }
        //状态判断
        if (curriculumCategory.getCategoryStatus() == CurriculumCategoryEnum.UP.getCode()) {
            throw new CurriculumException(ResultEnum.CURRICULUM_CATEGORY_STATUS_ERROR);
        }
        //更新
        curriculumCategory.setCategoryStatus(CurriculumCategoryEnum.UP.getCode());
        return curriculumCategoryDao.save(curriculumCategory);
    }

    @Override
    public CurriculumCategory offUsing(Integer categoryId) {
        CurriculumCategory curriculumCategory = curriculumCategoryDao.findOne(categoryId);
        //非空判断
        if (curriculumCategory == null) {
            throw new CurriculumException(ResultEnum.CURRICULUM_CATEGORY_NOT_EXIST);
        }
        //状态判断
        if (curriculumCategory.getCategoryStatus() == CurriculumCategoryEnum.DOWN.getCode()) {
            throw new CurriculumException(ResultEnum.CURRICULUM_CATEGORY_STATUS_ERROR);
        }
        //更新
        curriculumCategory.setCategoryStatus(CurriculumCategoryEnum.DOWN.getCode());
        return curriculumCategoryDao.save(curriculumCategory);
    }

    //封装成Eazyui的格式,返回给前端的视图对象
    @Override
    public List<CurriculumCategoryTreeVO> findCurriculumCategoryElement(Integer parentId) {
        List<CurriculumCategory> curriculumCategoryList = curriculumCategoryDao.findByParentId(parentId);
//      应该是需要转化成数组的?后端获取多选框后需要从json格式转化
        List<CurriculumCategoryTreeVO> curriculumCategoryTreeVOList = curriculumCategoryList.stream().map(e ->
                new CurriculumCategoryTreeVO(e.getParentId(),
                        e.getCategoryId(),
                        e.getCategoryName(),
                        e.getIsParent() ? "closed" : "open",
                        e.getIsParent() ? e.getCategoryElements() : null))
                .collect(Collectors.toList());

        return curriculumCategoryTreeVOList;
    }

    @Override
    public List<CurriculumCategoryTreeVO> findCurriculumCategoryList(Integer parentId) {
        List<CurriculumCategory> curriculumCategoryList = curriculumCategoryDao.findByParentId(parentId);

        List<CurriculumCategoryTreeVO> curriculumCategoryTreeVOList = curriculumCategoryList.stream().map(e ->
                new CurriculumCategoryTreeVO(e.getParentId(),
                        e.getCategoryId(),
                        e.getCategoryName(),
                        e.getIsParent() ? "closed" : "open"))
                .collect(Collectors.toList());

        return curriculumCategoryTreeVOList;
    }

    @Override
    public List<Integer> getCategoryAndDeepChildrenCategory(Integer categoryId) {

        Set<CurriculumCategory> categorySet = Sets.newHashSet();
        findChildCategory(categorySet, categoryId);


        List<Integer> categoryIdList = Lists.newArrayList();
        if (categoryId != null) {
            for (CurriculumCategory categoryItem : categorySet) {
                categoryIdList.add(categoryItem.getCategoryId());
            }
        }
        return categoryIdList;
    }

    private Set<CurriculumCategory> findChildCategory(Set<CurriculumCategory> categorySet, Integer categoryId) {
        CurriculumCategory category = curriculumCategoryDao.findOne(categoryId);
        if (category != null) {
            categorySet.add(category);
        }
        //查找子节点,递归算法一定要有一个退出的条件
        List<CurriculumCategory> categoryList = curriculumCategoryDao.findByParentId(categoryId);
        for (CurriculumCategory categoryItem : categoryList) {
            findChildCategory(categorySet, categoryItem.getCategoryId());
        }
        return categorySet;
    }
}
