package com.gzw.domain;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by gzw on 2017/1/17.
 */
public class Session implements Serializable{
    public static final String TIME_OUT = "time_out";
    public static final String CREATE_SESSION = "create_session";

    private HashMap<String,String> map;
    private long mTimeOut = 1000*60*30;

    public Session(){
        map = new HashMap<>();
        map.put(TIME_OUT,mTimeOut+"");
        map.put(CREATE_SESSION,System.currentTimeMillis()+"");
    }

    public long getmTimeOut() {
        return mTimeOut;
    }

    public void setmTimeOut(long mTimeOut) {
        this.mTimeOut = mTimeOut;
    }

    public HashMap<String, String> getMap() {
        return map;
    }

    public void setMap(HashMap<String, String> map) {
        this.map = map;
    }

    public String getAttr(String key){
        if(map == null || key == null){
            return null;
        }

        return map.get(key);
    }

    public boolean setAttr(String key,String value){
        if(map == null){
            map = new HashMap<>();
        }
        if(key == null){
            return false;
        }
        map.put(key,value);
        return true;

    }

    public void updateSession(){
        map.put(CREATE_SESSION,System.currentTimeMillis()+"");
    }

    public boolean isTimeOut(){
        long currentTime = System.currentTimeMillis();
        long createTime = Long.valueOf(map.get(CREATE_SESSION));
        if(currentTime - createTime > mTimeOut){
            return true;
        }else{
            return false;
        }

    }

}
