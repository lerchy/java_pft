package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.security.PublicKey;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by valeriyagagarina on 12/22/16.
 */
public class Groups extends ForwardingSet<GroupData> {

    private Set<GroupData> delegate;

    private Groups(Groups groups) {
        this.delegate = new HashSet<GroupData>(groups.delegate);
    }

    public Groups(){
        this.delegate = new HashSet<GroupData>();
    }

    @Override
    protected Set<GroupData> delegate() {
        return delegate;
    }

    public Groups withAdded(GroupData group){
        Groups groups = new Groups(this);
        groups.add(group);
        return groups;
    }

    public Groups without(GroupData group){
        Groups groups = new Groups(this);
        groups.remove(group);
        return groups;
    }
}

