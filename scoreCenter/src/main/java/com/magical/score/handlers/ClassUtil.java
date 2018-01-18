package com.magical.score.handlers;

/**
 * Created by zhouxp on 2018/1/16
 */
public class ClassUtil {

    /**
     * 根据这个类来获取默认的实例名（默认：将首字母换成小写）
     *
     * @param clazz
     *            类信息
     * @return 默认的实例名
     */
    public static String getDefaultInstanceName(Class<?> clazz) {
        if (clazz == null) {
            return null;
        }
        String className = clazz.getSimpleName();
        String firstLowerChar = className.substring(0, 1).toLowerCase();
        className = firstLowerChar + className.substring(1);
        return className;
    }
}
