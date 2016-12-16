package ru.stqa.pft.addressbook.model;

public class GroupData {
    private final String groupname;
    private int id;
    private final String groupheader;
    private final String groupfooter;

    public GroupData(int groupId, String groupname, String groupheader, String groupfooter) {
        this.id = groupId;
        this.groupname = groupname;
        this.groupheader = groupheader;
        this.groupfooter = groupfooter;
    }

    public GroupData(String groupname, String groupheader, String groupfooter) {
        this.id = 0;
        this.groupname = groupname;
        this.groupheader = groupheader;
        this.groupfooter = groupfooter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        if (id != groupData.id) return false;
        return groupname != null ? groupname.equals(groupData.groupname) : groupData.groupname == null;
    }

    @Override
    public int hashCode() {
        int result = groupname != null ? groupname.hashCode() : 0;
        result = 31 * result + id;
        return result;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "groupname='" + groupname + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public String getGroupname() {
        return groupname;
    }

    public String getGroupheader() {
        return groupheader;
    }

    public String getGroupfooter() {
        return groupfooter;
    }

    public void setId(int id) {
        this.id = id;
    }
}
