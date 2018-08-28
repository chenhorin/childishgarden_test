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


    public CurriculumDetail() {
    }

    public CurriculumDetail(String detailId, String curriculumId, String musicId, String musicName, String materialId,
                            String materialName, String bookId, String bookName, Date createTime, Date updateTime) {
        this.detailId = detailId;
        this.curriculumId = curriculumId;
        this.musicId = musicId;
        this.musicName = musicName;
        this.materialId = materialId;
        this.materialName = materialName;
        this.bookId = bookId;
        this.bookName = bookName;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }
}
