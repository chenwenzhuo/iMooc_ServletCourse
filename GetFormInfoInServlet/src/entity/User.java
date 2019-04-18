package entity;

import java.util.Date;

public class User {
    private String username;//用户名
    private String userPwd;//密码
    private String gender;//性别
    private Date birthday;//生日
    private String email;//电子邮箱
    private String[] favorites;//爱好
    private String introduction;//自我介绍
    private boolean accAgreement;//是否接受用户协议

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getFavorites() {
        return favorites;
    }

    public void setFavorites(String[] favorites) {
        this.favorites = favorites;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public boolean isAccAgreement() {
        return accAgreement;
    }

    public void setAccAgreement(boolean accAgreement) {
        this.accAgreement = accAgreement;
    }
}
