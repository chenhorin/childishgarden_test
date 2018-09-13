package net.codingtech.dao.mapper;

import net.codingtech.pojo.SchoolCampInfo;

public interface SchoolCampInfoMapper {
    int deleteByPrimaryKey(String campId);

    int insert(SchoolCampInfo record);

    int insertSelective(SchoolCampInfo record);

    SchoolCampInfo selectByPrimaryKey(String campId);

    int updateByPrimaryKeySelective(SchoolCampInfo record);

    int updateByPrimaryKey(SchoolCampInfo record);
}