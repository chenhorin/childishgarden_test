package net.codingtech.service.impl;

import net.codingtech.dao.CurriculumCategoryDao;
import net.codingtech.dataobject.CurriculumCategory;
import net.codingtech.enums.CurriculumCategoryEnum;
import net.codingtech.enums.ResultEnum;
import net.codingtech.exception.CurriculumException;
import net.codingtech.service.CurriculumCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @program: childishgarden_test
 * @description: 分类服务的实现类
 * @author: hongren
 * @create: 2018-08-14 16:08
 **/
@Service
public class CurriculumCategoryServiceImpl implements CurriculumCategoryService {

    @Autowired
    CurriculumCategoryDao curriculumCategoryDao;

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
    public CurriculumCategory save(CurriculumCategory curriculumCategory) {
//      TODO 表单的校验,格式是否正确
        return curriculumCategoryDao.save(curriculumCategory);
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
   /* public List<CurriculumCategoryTreeVO> findCurriculumCategoryList(Integer parentId) {
        List<CurriculumCategory> curriculumCategoryList = curriculumCategoryDao.findByParentId(parentId);

        List<CurriculumCategoryTreeVO> curriculumCategoryTreeVOList = curriculumCategoryList.stream().map(e ->
                new CurriculumCategoryTreeVO(e.getParentId(), e.getCategoryName(), e.getIsParent() ? "closed" : "open"))
                .collect(Collectors.toList());

        return curriculumCategoryTreeVOList;
    }*/
}
