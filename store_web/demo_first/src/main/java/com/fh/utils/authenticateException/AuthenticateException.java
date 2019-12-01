package com.fh.utils.authenticateException;


import com.fh.utils.enumbean.LoginEnum;

public class AuthenticateException extends RuntimeException{



    private Integer code;
    public AuthenticateException(LoginEnum loginEnum) {
        super(loginEnum.getMessage());
        this.code=loginEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }
}
