package com.example.akosha.sample1.nucleuspoc.pocpkg.data;

import retrofit.http.GET;
import rx.Observable;

/**
 * Created by kushagarlall on 14/01/16.
 */
public interface MockApi {
    public static final String ENDPOINT = "http://www.mocky.io";

    @GET("/v2/56977c132500000a2d1b0065")
    Observable<MockData> getMockData();
}
