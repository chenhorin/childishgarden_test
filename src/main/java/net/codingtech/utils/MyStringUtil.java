package net.codingtech.utils;

public class MyStringUtil {
    //    字符数组转成字符串
    public static String stringArray2StringConvert(String[] strings) {
//        字符串数组传化格式
        StringBuffer stringBuffer = new StringBuffer();
        for (String stringElement : strings) {
            stringBuffer.append(stringElement + ",");
        }
//        去掉最后一个逗号
        stringBuffer.replace(stringBuffer.length() - 1, stringBuffer.length(), "");
        return stringBuffer.toString();
    }
}
