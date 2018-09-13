package net.codingtech.dto;

import lombok.Data;
import net.codingtech.pojo.CourseSelection;

import java.util.List;

@Data
public class CourseSelectionDTO {


    private List<CourseSelection> monday;
    private List<CourseSelection> tuesday;
    private List<CourseSelection> wednesday;
    private List<CourseSelection> thursday;
    private List<CourseSelection> friday;
    private List<CourseSelection> saturday;
    private List<CourseSelection> sunday;

}
