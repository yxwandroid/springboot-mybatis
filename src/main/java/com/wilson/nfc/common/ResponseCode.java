package com.wilson.nfc.common;

/**
 * Created by yangxuewu on 2018/6/21.
 */
public enum ResponseCode {

    SUCCESS(0, "SUCCESS"),
    ERROR(1,"ERROR"),
    NEED_LOGIN(2,"NEED_LOGIN"),;

    private final int code;
    private final String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
