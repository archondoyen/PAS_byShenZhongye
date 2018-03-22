package com.archon.util;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by xiaohuang on 2018/1/17.
 */
public class TimeUtil {

    public  static Timestamp  getTimeStamp(){
        return   new Timestamp(new Date().getTime());
    }
}
