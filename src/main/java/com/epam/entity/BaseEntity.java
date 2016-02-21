package com.epam.entity;

/**
 * Created by Munar on 22.02.2016.
 */
public class BaseEntity {
    private int id;

    BaseEntity(int id){
        this.id = id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
