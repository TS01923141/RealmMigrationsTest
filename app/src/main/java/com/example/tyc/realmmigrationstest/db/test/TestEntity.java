package com.example.tyc.realmmigrationstest.db.test;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by biji on 2018/8/27.
 */

public class TestEntity extends RealmObject {
    @PrimaryKey
    private String id;
    private String name;
    private String age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
