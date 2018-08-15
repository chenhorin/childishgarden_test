package net.codingtech.dao;

import net.codingtech.dataobject.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: childishgarden_test
 * @description: 书籍分类dao
 * @author: hongren
 * @create: 2018-08-13 16:30
 **/
public interface BookCategoryDao extends JpaRepository<BookCategory,Integer> {
}
