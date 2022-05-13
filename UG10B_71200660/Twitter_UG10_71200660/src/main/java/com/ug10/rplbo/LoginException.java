package com.ug10.rplbo;

public class LoginException extends Exception{
    private int errCode;
    private String errMsg;

    public LoginException(int errorCode){
        this.errCode = errorCode;

        if(errorCode == 1){
            this.errMsg = "Input username tidak boleh kosong";
        }else if(errorCode == 2){
            this.errMsg = "Input password tidak boleh kosong";
        }else if(errorCode == 3){
            this.errMsg = "Username atau Password salah";
        }
    }

    public int getErrCode() {
        return errCode;
    }

    @Override
    public String getMessage() {
        return errMsg;
    }
}
