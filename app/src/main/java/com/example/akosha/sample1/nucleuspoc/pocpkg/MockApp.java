package com.example.akosha.sample1.nucleuspoc.pocpkg;

import android.app.Application;
import android.util.Log;

import com.example.akosha.sample1.nucleuspoc.pocpkg.data.MockApi;

import retrofit.RestAdapter;

/**
 * Created by kushagarlall on 14/01/16.
 */
public class MockApp extends Application {
    private static MockApi mockApi;

    @Override
    public void onCreate() {
        super.onCreate();
        mockApi = new RestAdapter.Builder()
                .setEndpoint(MockApi.ENDPOINT)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setLog(new RestAdapter.Log() {
                    @Override
                    public void log(String message) {
                        Log.v("MockApi", message);
                    }
                })
                .build().create(MockApi.class);
    }

    public static MockApi getMockApi() {
        return mockApi;
    }
}
