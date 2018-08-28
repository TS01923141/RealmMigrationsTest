package com.example.tyc.realmmigrationstest.db.person;


import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by biji on 2018/8/28.
 */

public class PersonDao {
    protected Realm db;

    public PersonDao(Realm db) {
        this.db = db;
    }

    public void insert(final String newPrimaryKey, final PersonEntity newPersonEntity){
        db.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                PersonEntity testEntity = realm.createObject(PersonEntity.class , newPrimaryKey);

                testEntity.setAge(newPersonEntity.getAge());
                testEntity.setName(newPersonEntity.getName());
            }
        });
    }

    public void update(final String primaryKey, final PersonEntity newPersonEntity){
        db.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                PersonEntity testEntity = where().equalTo("id" , primaryKey).findFirst();
                testEntity.setAge(newPersonEntity.getAge());
                testEntity.setName(newPersonEntity.getName());
            }
        });
    }

    public RealmResults<PersonEntity> searchAll(){
        return db.where(PersonEntity.class).findAll();
    }


    public RealmResults<PersonEntity> searchData(String searchType, String searchEqual){
        return where().equalTo(searchType, searchEqual).findAll();
    }

    public void delete(final String position){
        db.executeTransaction(new Realm.Transaction(){
            @Override
            public void execute(Realm realm){
                RealmResults<PersonEntity> users = realm.where(PersonEntity.class).findAll();
                users.deleteFromRealm(Integer.parseInt(position));
            }
        });
    }
    public void close(){
        db.close();
    }

    private RealmQuery<PersonEntity> where() {
        return db.where(PersonEntity.class);
    }
}
