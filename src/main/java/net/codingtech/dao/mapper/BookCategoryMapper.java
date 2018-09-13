package net.codingtech.dao.mapper;

import net.codingtech.pojo.BookCategory;

public interface BookCategoryMapper {
    int deleteByPrimaryKey(Integer categoryId);

    int insert(BookCategory record);

    int insertSelective(BookCategory record);

    BookCategory selectByPrimaryKey(Integer categoryId);

    int updateByPrimaryKeySelective(BookCategory record);

    int updateByPrimaryKey(BookCategory record);
}