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

    //父类Id
    private Integer id;
    private Integer categoryId;
    private String text;
    private String  state;
    //TODO 数组还是字符待定
    private String element;

    public CurriculumCategoryTreeVO() {
    }

    public CurriculumCategoryTreeVO(Integer id, Integer categoryId, String text, String state,String element) {
        this.id = id;
        this.categoryId = categoryId;
        this.text = text;
        this.state = state;
        this.element = element;
    }

    public CurriculumCategoryTreeVO(Integer id, Integer categoryId, String text, String state) {
        this.id = id;
        this.categoryId = categoryId;
        this.text = text;
        this.state = state;
    }
}
