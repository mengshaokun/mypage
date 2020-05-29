package com.mypage.utils;

import java.util.List;

/**
 * @author mengsk
 * @date 2020/5/27
 */
public class ListUtils {

    /**
     * 判断list是否为空
     * @param list
     * @return
     */
    public static boolean isNotNull(List list) {
        return list != null && list.size() > 0;
    }
}
