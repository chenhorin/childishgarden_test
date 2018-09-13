package net.codingtech.dao.mapper;

import net.codingtech.pojo.BookInfo;

public interface BookInfoMapper {
    int deleteByPrimaryKey(String bookId);

    int insert(BookInfo record);

    int insertSelective(BookInfo record);

    BookInfo selectByPrimaryKey(String bookId);

    int updateByPrimaryKeySelective(BookInfo record);

    int updateByPrimaryKey(BookInfo record);
}