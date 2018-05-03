package com.example.sauceda.ideasapp.utils;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmObject;

/**
 * Created by sauceda on 10/02/18.
 */

public class App extends Application {

    private static Realm realm;
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);

        realm = Realm.getDefaultInstance();
    }

    public static Realm getRealm() {
        return realm;
    }
}
