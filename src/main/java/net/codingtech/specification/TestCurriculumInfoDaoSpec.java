package net.codingtech.specification;

import net.codingtech.pojo.CurriculumInfo;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class TestCurriculumInfoDaoSpec {
    public static Specification<CurriculumInfo> getSpec(CurriculumInfo curriculumInfo) {
        return new Specification<CurriculumInfo>() {

            @SuppressWarnings("unused")
            @Override
            public Predicate toPredicate(Root<CurriculumInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                Predicate p1 = null;
                if (curriculumInfo.getCurriculumProperty() != null) {
                    Predicate p2 = cb.equal(root.get("curriculumProperty"), curriculumInfo.getCurriculumProperty());
                    if (p1 != null) {
                        p1=cb.and(p1, p2);
                    } else {
                        p1 = p2;
                    }
                }
                if (curriculumInfo.getCurriculumAge() != null) {
                    Predicate p2 = cb.equal(root.get("curriculumAge"), curriculumInfo.getCurriculumAge());
                    if (p1 != null) {
                        p1=cb.and(p1, p2);
                    } else {
                        p1 = p2;
                    }
                }
                if (curriculumInfo.getCategoryId() != null) {
                    Predicate p2 = cb.equal(root.get("categoryId"), curriculumInfo.getCategoryId());
                    if (p1 != null) {
                        p1=cb.and(p1, p2);
                    } else {
                        p1 = p2;
                    }
                }
                return p1;
            }
        };
    }

}
