package com.ug10.rplbo;

public class TweetException extends Exception{
    private int errCode;
    private String errMsg;

    public TweetException(int errorCode){
        this.errCode = errorCode;

        if(errorCode == 1){
            this.errMsg = "Input tweet tidak boleh kosong";
        }else if(errorCode == 2){
            this.errMsg = "Tweet minimal harus terdiri dari 8 karakter dan maksimal 140 karakter";
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
