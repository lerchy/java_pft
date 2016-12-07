package ru.stqa.pft.addressbook.model;

public class UserData {
    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final String nickname;
    private final String title;
    private final String company;
    private final String homephone;
    private final String mobilephone;
    private final String address;
    private String group;

    public UserData(String firstname, String middlename,
                    String lastname, String nickname,
                    String title, String company,
                    String homephone, String mobilephone,
                    String address, String group) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.title = title;
        this.company = company;
        this.homephone = homephone;
        this.mobilephone = mobilephone;
        this.address = address;
        this.group = group;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getHomephone() {
        return homephone;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public String getAddress() {
        return address;
    }

    public String getGroup() { return group; }
}
