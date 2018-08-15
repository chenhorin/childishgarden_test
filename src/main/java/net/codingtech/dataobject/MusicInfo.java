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
public class MusicInfo {

    @Id
    private String musicId;
    private String musicName;
    private Integer categoryId;
    private String musicPic;
    private String musicUrl;
    private Integer musicStatus;
    private Date createTime;
    private Date updateTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MusicInfo musicInfo = (MusicInfo) o;
        return categoryId == musicInfo.categoryId &&
                musicStatus == musicInfo.musicStatus &&
                Objects.equals(musicId, musicInfo.musicId) &&
                Objects.equals(musicName, musicInfo.musicName) &&
                Objects.equals(musicPic, musicInfo.musicPic) &&
                Objects.equals(musicUrl, musicInfo.musicUrl) &&
                Objects.equals(createTime, musicInfo.createTime) &&
                Objects.equals(updateTime, musicInfo.updateTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(musicId, musicName, categoryId, musicPic, musicUrl, musicStatus, createTime, updateTime);
    }
}
