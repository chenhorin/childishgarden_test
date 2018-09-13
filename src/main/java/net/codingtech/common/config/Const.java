package net.codingtech.common.config;

import com.google.common.collect.Sets;

import java.util.Set;

public class Const {

    public static final String CURRENT_USER = "currentUser";
    public static final String EMAIL = "email";
    public static final String USERNAME = "username";

    public interface CurriculumListOrderBy{
        Set<String> CREATETIME_ASC_DESC = Sets.newHashSet("createTime_desc","createTime_asc");
    }
}
