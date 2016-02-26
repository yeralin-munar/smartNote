package com.epam.entity;

/**
 * Created by Munar on 22.02.2016.
 */
class BaseEntity {
    private Integer id;

    BaseEntity(int id){
        this.id = id;
    }
    public void setId(int id) {
        this.id = id;
    }

    int getId() {
        return id;
    }
}
