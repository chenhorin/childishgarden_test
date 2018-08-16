package net.codingtech.service;

import net.codingtech.dataobject.CurriculumInfo;

import java.util.List;

/**
 * @program: childishgarden_test
 * @description: 课程服务
 * @author: hongren
 * @create: 2018-08-14 17:07
 **/
public interface CurriculumService {

    //通过分类id查询课程
    List<CurriculumInfo> findByCategoryId(Integer id);

    //通过分类id查询在线的课程
    //添加课程
    //设置课程在线
    //设置课程下线
    //查询所有课程
    //查询所有在线课程
    //查询
    //根据年龄区间查询课程
    //根据课程属性查询课程,动态查询
    //管理页面的显示,返回字段课程名 适合年龄,领域,区块...单选框的录入
    //需要考虑的是分类的添加是否需要做多选?

    List<CurriculumInfo> findByDynamicCases(CurriculumInfo curriculumInfo);
}
