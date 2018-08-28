package com.example.tyc.realmmigrationstest.db.test;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by biji on 2018/8/27.
 */

public class TestDao {
    protected Realm db;

    public TestDao(Realm db) {
        this.db = db;
    }

    public void insert(final String newPrimaryKey, final TestEntity newTestEntity){
        db.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                TestEntity testEntity = realm.createObject(TestEntity.class , newPrimaryKey);

                testEntity.setAge(newTestEntity.getAge());
                testEntity.setName(newTestEntity.getName());
            }
        });
    }

    public void update(final String primaryKey, final TestEntity newTestEntity){
        db.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                TestEntity testEntity = where().equalTo("id" , primaryKey).findFirst();
                testEntity.setAge(newTestEntity.getAge());
                testEntity.setName(newTestEntity.getName());
            }
        });
    }

    public RealmResults<TestEntity> searchAll(){
        return db.where(TestEntity.class).findAll();
    }


    public RealmResults<TestEntity> searchData(String searchType, String searchEqual){
        return where().equalTo(searchType, searchEqual).findAll();
    }

    public void delete(final String position){
        db.executeTransaction(new Realm.Transaction(){
            @Override
            public void execute(Realm realm){
                RealmResults<TestEntity> users = realm.where(TestEntity.class).findAll();
                users.deleteFromRealm(Integer.parseInt(position));
            }
        });
    }
    public void close(){
        db.close();
    }

    private RealmQuery<TestEntity> where() {
        return db.where(TestEntity.class);
    }
}
