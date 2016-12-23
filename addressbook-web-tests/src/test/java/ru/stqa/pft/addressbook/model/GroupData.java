package ru.stqa.pft.addressbook.model;

public class GroupData {
    private String name;
    private int id;
    private String header;
    private String footer;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "groupname='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

    public GroupData withId(int id) {

        this.id = id;
        return this;
    }

    public GroupData withName(String groupname) {
        this.name = groupname;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        if (id != groupData.id) return false;
        return name != null ? name.equals(groupData.name) : groupData.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + id;
        return result;
    }

    public GroupData withHeader(String header) {
        this.header = header;
        return this;
    }

    public GroupData withFooter(String footer) {
        this.footer = footer;
        return this;
    }

}
