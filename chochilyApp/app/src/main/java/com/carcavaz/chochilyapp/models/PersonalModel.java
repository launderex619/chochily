package com.carcavaz.chochilyapp.models;


public class PersonalModel {
    private String UserId;
    private String PictureSrc;
    private String UserName;
    private String Code;
    private String Email;

    public PersonalModel(String userId, String pictureSrc, String userName, String code, String email) {
        UserId = userId;
        PictureSrc = pictureSrc;
        UserName = userName;
        Code = code;
        Email = email;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getPictureSrc() {
        return PictureSrc;
    }

    public void setPictureSrc(String pictureSrc) {
        PictureSrc = pictureSrc;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
