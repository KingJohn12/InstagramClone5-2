package com.example.instagramclone5;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);


        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("k7IKcTEwRDGF1BXeDfANXbVTVxGqDA6uIdPyHQG3")
                .clientKey("qjuwQL2WqQDGd0GjWKwoslbyxyzHK2vT9ehHBVrj")
                .server("https://parseapi.back4app.com")
                .build()
        );

    }
}
