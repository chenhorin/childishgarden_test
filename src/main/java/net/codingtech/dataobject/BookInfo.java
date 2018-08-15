package net.codingtech.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

/**
 * @program: childishgarden_test
 * @description:
 * @author: hongren
 * @create: 2018-08-13 15:12
 **/
@Entity
@Data
@DynamicUpdate
public class BookInfo {

    @Id
    private String bookId;
    private Integer categoryId;
    private String bookName;
    private String bookPic;
    private Integer bookStatus;
    private Date createTime;
    private Date updateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookInfo bookInfo = (BookInfo) o;
        return categoryId == bookInfo.categoryId &&
                bookStatus == bookInfo.bookStatus &&
                Objects.equals(bookId, bookInfo.bookId) &&
                Objects.equals(bookName, bookInfo.bookName) &&
                Objects.equals(bookPic, bookInfo.bookPic) &&
                Objects.equals(createTime, bookInfo.createTime) &&
                Objects.equals(updateTime, bookInfo.updateTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(bookId, categoryId, bookName, bookPic, bookStatus, createTime, updateTime);
    }
}
