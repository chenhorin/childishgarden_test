package net.codingtech.service.impl;

import net.codingtech.dao.CurriculumCategoryDao;
import net.codingtech.dataobject.CurriculumCategory;
import net.codingtech.service.CurriculumCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        curriculumCategoryDao.findOne(categoryId);
        return null;
    }

    @Override
    public List<CurriculumCategory> findAll() {
        return null;
    }

    @Override
    public List<CurriculumCategory> findAllSonCategory() {
        return null;
    }

    @Override
    public List<CurriculumCategory> findByParentId(Integer parentId) {
        return null;
    }

    @Override
    public CurriculumCategory save(CurriculumCategory curriculumCategory) {
        return null;
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
