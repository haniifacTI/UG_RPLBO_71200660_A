package com.ug10.rplbo;

public class UsernameException extends Exception{
    private int errCode;
    private String errMsg;

    public UsernameException(int errorCode){
        this.errCode = errorCode;

        if(errorCode == 1){
            this.errMsg = "Input username tidak boleh kosong";
        }else if(errorCode == 2){
            this.errMsg = "Username minimal harus terdiri dari 6 karakter";
        }else if(errorCode == 3){
            this.errMsg = "Username hanya boleh terdiri dari huruf, angka, dan simbol underscore";
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
