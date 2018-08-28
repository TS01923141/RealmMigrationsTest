package com.example.tyc.realmmigrationstest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tyc.realmmigrationstest.db.RealmMigration;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm.init(getApplication());
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .schemaVersion(1)
                .migration(new RealmMigration())
                .build();
        Realm.setDefaultConfiguration(configuration);
        Realm realm = Realm.getDefaultInstance();

    }
}
