package com.quickblox.qbpeople.models;

/**
 * Created by tereha on 17.01.16.
 */
public class Employe {

    private String fullName;
    private String position;
    private String skype;
    private String eMail;
    private String telephone;
    private String additionalTelephone;

    public Employe (){
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdditionalTelephone() {
        return additionalTelephone;
    }

    public void setAdditionalTelephone(String additionalTelephone) {
        this.additionalTelephone = additionalTelephone;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(Employe.class.getSimpleName());
        stringBuilder.append("{")
                .append("fullName").append("=").append(getFullName()).append(", ")
                .append("position").append("=").append(getPosition()).append(", ")
                .append("skype").append("=").append(getSkype()).append(", ")
                .append("eMail").append("=").append(geteMail()).append(", ")
                .append("telephone").append("=").append(getTelephone()).append(", ")
                .append("additionalTelephone").append("=").append(getAdditionalTelephone())
                .append("}");
        return stringBuilder.toString();
    }
}
