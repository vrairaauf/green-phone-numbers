package org.raaufcodeforandroid.greennumbertunisia.model;

public class GreenPhone {
    private String name;
    private String phoneNumber;


    public String getName() {
        return name;
    }

    public GreenPhone(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}