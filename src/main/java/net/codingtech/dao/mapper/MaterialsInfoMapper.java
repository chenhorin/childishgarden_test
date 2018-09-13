package net.codingtech.dao.mapper;

import net.codingtech.pojo.MaterialsInfo;

public interface MaterialsInfoMapper {
    int deleteByPrimaryKey(String materialId);

    int insert(MaterialsInfo record);

    int insertSelective(MaterialsInfo record);

    MaterialsInfo selectByPrimaryKey(String materialId);

    int updateByPrimaryKeySelective(MaterialsInfo record);

    int updateByPrimaryKey(MaterialsInfo record);
}