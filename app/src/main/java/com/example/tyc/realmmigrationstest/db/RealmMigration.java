package com.example.tyc.realmmigrationstest.db;

import android.util.Log;

import io.realm.DynamicRealm;
import io.realm.FieldAttribute;
import io.realm.RealmSchema;

/**
 * Created by biji on 2018/8/28.
 */

public class RealmMigration implements io.realm.RealmMigration {
    private static final String TAG = "RealmMigration";

    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        RealmSchema schema = realm.getSchema();
        Log.d(TAG, "migrate: schema: " + schema);
        Log.d(TAG, "migrate: oldVersion: " + oldVersion);
        Log.d(TAG, "migrate: newVersion: " + newVersion);

        if (oldVersion == 0){
            schema.create("PersonEntity")
                    .addField("id" , String.class, FieldAttribute.PRIMARY_KEY)
                    .addField("name" , String.class)
                    .addField("age", String.class);
        }
    }
}
