package com.epam.entity;

import com.epam.entity.BaseEntity;

/**
 * Created by Munar on 22.02.2016.
 */
public class Category extends BaseEntity {
    private String name;

    public Category(int id, String name){
        super(id);
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
