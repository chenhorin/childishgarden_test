package net.codingtech.dao;

import net.codingtech.pojo.BookInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: childishgarden_test
 * @description: 书籍信息dao
 * @author: hongren
 * @create: 2018-08-13 16:31
 **/
public interface BookInfoRepository extends JpaRepository<BookInfo,String> {
}
