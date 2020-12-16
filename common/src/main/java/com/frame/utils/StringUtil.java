package com.frame.utils;

/**
 * <pre>
 * 对象功能 字符串工具类
 * 开发人员：曾煜
 * 创建时间：2020/12/16 20:24
 * </pre>
 **/
public class StringUtil {

    /**
     * 判断字符串是否为空 null或去除两边空格后判断
     * @param string 字符串
     * @return 空返回 true 否则 false
     */
    public static boolean isEmpty(String string){
        if(string==null || string.trim().equals("")){
            return true;
        }
        return false;
    }

}
