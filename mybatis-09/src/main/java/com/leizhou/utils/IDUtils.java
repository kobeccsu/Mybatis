package com.leizhou.utils;

import java.util.UUID;

public class IDUtils {

    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
