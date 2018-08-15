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
public class CurriculumDetail {

    @Id
    private String detailId;
    private String curriculumId;
    private String musicId;
    private String musicName;
    private String materialId;
    private String materialName;
    private String bookId;
    private String bookName;
    private Date createTime;
    private Date updateTime;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurriculumDetail that = (CurriculumDetail) o;
        return Objects.equals(detailId, that.detailId) &&
                Objects.equals(curriculumId, that.curriculumId) &&
                Objects.equals(musicId, that.musicId) &&
                Objects.equals(musicName, that.musicName) &&
                Objects.equals(materialId, that.materialId) &&
                Objects.equals(materialName, that.materialName) &&
                Objects.equals(bookId, that.bookId) &&
                Objects.equals(bookName, that.bookName) &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(detailId, curriculumId, musicId, musicName, materialId, materialName, bookId, bookName, createTime, updateTime);
    }
}
