package net.codingtech.dao;

import net.codingtech.pojo.BookCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookCategoryRepositoryTest {

    @Autowired
    BookCategoryRepository bookCategoryRepository;

    @Test
    public void findTest() {
        BookCategory bookCategory = bookCategoryRepository.findOne(1);
        Assert.assertNotNull(bookCategory);
    }
}