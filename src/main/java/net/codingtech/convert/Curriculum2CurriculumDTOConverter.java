package net.codingtech.convert;

import net.codingtech.pojo.CurriculumInfo;
import net.codingtech.dto.CurriculumDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class Curriculum2CurriculumDTOConverter {

    public static CurriculumDTO convert(CurriculumInfo curriculumInfo) {
        CurriculumDTO curriculumDTO = new CurriculumDTO();
        BeanUtils.copyProperties(curriculumInfo, curriculumDTO);
        return curriculumDTO;
    }

    public static List<CurriculumDTO> convert(List<CurriculumInfo> curriculumInfoList) {
        return curriculumInfoList.stream().map(e ->
                convert(e)).collect(Collectors.toList());
    }
}
