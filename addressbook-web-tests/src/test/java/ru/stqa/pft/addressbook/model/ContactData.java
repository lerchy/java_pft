package ru.stqa.pft.addressbook.model;

import java.io.File;

public class ContactData {
    private String firstname;
    private String lastname;
    private String homephone;
    private String mobilephone;
    private String workphone;
    private String allPhones;
    private String address;
    private String email1;
    private String email2;
    private String email3;
    private String allEmails;
    private String group;
    private int id;
    private File photo;

    // getters
    public String getFirstname() {
        return firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public String getMobilephone() {
        return mobilephone;
    }
    public String getHomephone() { return homephone; }
    public String getWorkphone() { return workphone; }
    public String getAllPhones() { return allPhones; }
    public String getEmail1() { return email1; }
    public String getEmail2() { return email2; }
    public String getEmail3() { return email3; }
    public String getAllEmails() { return allEmails;}
    public String getAddress() {
        return address;
    }
    public String getGroup() { return group; }
    public int getId(){ return id;}
    public File getPhoto() { return photo; }

    // setters
    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withHomePhone(String homephone) {
        this.homephone = homephone;
        return this;
    }

    public ContactData withMobilePhone(String mobilephone) {
        this.mobilephone = mobilephone;
        return this;
    }

    public ContactData withWorkPhone(String workphone) {
        this.workphone = workphone;
        return this;
    }

    public ContactData withAllPhone(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withEmail1(String email) {
        this.email1 = email;
        return this;
    }

    public ContactData withEmail2(String email) {
        this.email2 = email;
        return this;
    }

    public ContactData withEmail3(String email) {
        this.email3 = email;
        return this;
    }

    public ContactData withAllEmails(String emails) {
        this.allEmails = emails;
        return this;
    }

    public ContactData inGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public String getFullName() {
        return firstname + " " + lastname;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id='" +id + '\''+
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
