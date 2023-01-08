package com.teldrasill.exception;

public class UserLoginException extends Exception
{
    //验证的版本一致
    private static final long serialVersionUID = 1L;

    public UserLoginException(String message)
    {
        super(message);
    }
}
