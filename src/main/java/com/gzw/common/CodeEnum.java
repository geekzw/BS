package com.gzw.common;

/**
 * Created by gzw on 2017/1/17.
 */
public enum CodeEnum {
    LOGIN_SUCCESS(ResultCode.LOGIN_SUCCESS,ResultCode.LOGIN_SUCCESS_DES),
    NO_USER(ResultCode.NO_USER,ResultCode.NO_USER_DES),
    PASSWORD_ERROR(ResultCode.PASSWORD_ERROR,ResultCode.PASSWORD_ERROR_DES),
    ;
    private int code;
    private String description;

    CodeEnum(int code,String description){
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

    public static CodeEnum getCodeEnum(int code){
        switch (code){
            case ResultCode.LOGIN_SUCCESS:
                return LOGIN_SUCCESS;
            case ResultCode.NO_USER:
                return NO_USER;
            case ResultCode.PASSWORD_ERROR:
                return PASSWORD_ERROR;
        }
        return null;
    }
}
