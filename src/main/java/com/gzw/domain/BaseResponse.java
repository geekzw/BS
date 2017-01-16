package com.gzw.domain;

/**
 * Created by shuai on 17/1/16.
 */
public class BaseResponse<T> {
    public int resultCode;
    public String codeDescription;
    public T result;
}
