package net.codingtech.convert;

import net.codingtech.dataobject.CourseSelection;
import net.codingtech.dto.CourseSelectionDTO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CourseSelection2CourseSelectionDTOConverter {

    public CourseSelection2CourseSelectionDTOConverter() {
    }



    //将课程转化成dto对象
    public static CourseSelectionDTO convert(List<CourseSelection> courseSelectionList) {


        CourseSelectionDTO courseSelectionDTO = new CourseSelectionDTO();

        List<CourseSelection> monday = new ArrayList<>();
        List<CourseSelection> tuesday = new ArrayList<>();
        List<CourseSelection> wednesday = new ArrayList<>();
        List<CourseSelection> thursday = new ArrayList<>();
        List<CourseSelection> friday = new ArrayList<>();
        List<CourseSelection> saturday = new ArrayList<>();
        List<CourseSelection> sunday = new ArrayList<>();

        //遍历选课的集合
        for (CourseSelection courseSelection : courseSelectionList) {
            Integer dateToWeekNum = dateToWeekNum(courseSelection.getCourseDay());
            switch (dateToWeekNum) {
                case 1:
                    sunday.add(courseSelection);
                    break;
                //todo 当天课表排序
                case 2:
                    monday.add(courseSelection);
                    break;
                case 3:
                    tuesday.add(courseSelection);
                    break;
                case 4:
                    wednesday.add(courseSelection);
                    break;
                case 5:
                    thursday.add(courseSelection);
                    break;
                case 6:
                    friday.add(courseSelection);
                    break;
                case 7:
                    saturday.add(courseSelection);
                    break;
            }
        }
        courseSelectionDTO.setMonday(monday);
        courseSelectionDTO.setTuesday(tuesday);
        courseSelectionDTO.setWednesday(wednesday);
        courseSelectionDTO.setThursday(thursday);
        courseSelectionDTO.setFriday(friday);
        courseSelectionDTO.setSaturday(saturday);
        courseSelectionDTO.setSunday(sunday);
        return courseSelectionDTO;
    }

    //将时间转化成周
    public static String dateToWeek(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return new SimpleDateFormat("EEEE").format(c.getTime());
    }

    //将时间转化成周对应的Num
    public static Integer dateToWeekNum(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.DAY_OF_WEEK);
    }
}
