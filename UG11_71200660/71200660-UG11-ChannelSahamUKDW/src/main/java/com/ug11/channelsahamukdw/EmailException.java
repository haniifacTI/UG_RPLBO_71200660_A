package com.ug11.channelsahamukdw;


public class EmailException extends Throwable {
    private String errorMessage;
    private int errorCode;

    public EmailException(int code){
        this.errorCode = code;
        if(code == 1){
            errorMessage = "Login gagal! email anda tidak terdaftar dalam UKDW";
        }else if(code == 2){
            errorMessage = "Login gagal! email UKDW anda tidak valid";
        }
    }

    public String getErrorMessage(){
        return errorMessage;
    }
}
