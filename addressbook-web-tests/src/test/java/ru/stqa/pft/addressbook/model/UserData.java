package ru.stqa.pft.addressbook.model;

public class UserData {
    private final String firstname;
    private final String middlename;
    private final String lastname;

    private String nickname;
    private String title;
    private String company;
    private String homephone;
    private String mobilephone;
    private String address;
    private String group;
    private int id;

    public UserData(String firstname, String middlename,
                    String lastname, String nickname,
                    String title, String company,
                    String homephone, String mobilephone,
                    String address, String group, int id) {
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
        this.id = id;
    }

    public UserData(String firstname, String middlename, String lastname, String group) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.group = group;
        this.id = Integer.MAX_VALUE;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserData userData = (UserData) o;

        if (firstname != null ? !firstname.equals(userData.firstname) : userData.firstname != null) return false;
        return lastname != null ? lastname.equals(userData.lastname) : userData.lastname == null;
    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }
}
