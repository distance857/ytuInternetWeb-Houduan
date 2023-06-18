package com.example.internetwork.request;


import com.example.internetwork.entity.CodeData;
import com.example.internetwork.entity.FormData;
import com.example.internetwork.entity.NameData;
import lombok.Data;

@Data
public class AddressRequest {
    private CodeData codedata;
    private FormData formdata;
    private NameData namedata;
    private String usertoken;

    public String getUsertoken() {
        return usertoken;
    }

    public void setUsertoken(String usertoken) {
        this.usertoken = usertoken;
    }

    public AddressRequest(CodeData codedata, FormData formdata, NameData namedata, String usertoken) {
        this.codedata = codedata;
        this.formdata = formdata;
        this.namedata = namedata;
        this.usertoken = usertoken;
    }

    public AddressRequest() {
    }

    public AddressRequest(CodeData codedata, FormData formdata, NameData namedata) {
        this.codedata = codedata;
        this.formdata = formdata;
        this.namedata = namedata;
    }

    public CodeData getCodedata() {
        return codedata != null ? codedata : new CodeData();
    }

    public void setCodedata(CodeData codedata) {
        this.codedata = codedata;
    }

    public FormData getFormdata() {
        return formdata != null ? formdata : new FormData();
    }

    public void setFormdata(FormData formdata) {
        this.formdata = formdata;
    }

    public NameData getNamedata() {
        return namedata != null ? namedata : new NameData();
    }

    public void setNamedata(NameData namedata) {
        this.namedata = namedata;
    }

    @Override
    public String toString() {
        return "AddressRequest{" +
                "codedata=" + codedata +
                ", formdata=" + formdata +
                ", namedata=" + namedata +
                ", usertoken='" + usertoken + '\'' +
                '}';
    }
}