package com.ug10.rplbo;

public class BioException extends Exception{
    private int errCode;
    private String errMsg;

    public BioException(int errorCode){
        this.errCode = errorCode;

        if(errorCode == 1){
            this.errMsg = "Input bio tidak boleh kosong";
        }else if(errorCode == 2){
            this.errMsg = "Bio minimal harus terdiri dari 5 karakter dan maksimal 30 karakter";
        }else if(errorCode == 3){
            this.errMsg = "Bio tidak boleh mengandung karakter spesial selain titik, @, serta spasi";
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
