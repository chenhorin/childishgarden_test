package net.codingtech.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: childishgarden_test
 * @description: 树形菜单的返回结果, 同时需要获得叶节点Id
 * @author: hongren
 * @create: 2018-08-14 15:39
 **/
@Data
public class CurriculumCategoryTreeVO implements Serializable {

    private Integer id;
    private String text;
    private String  state;

    public CurriculumCategoryTreeVO() {
    }

    public CurriculumCategoryTreeVO(Integer id, String text, String state) {
        this.id = id;
        this.text = text;
        this.state = state;
    }
}
