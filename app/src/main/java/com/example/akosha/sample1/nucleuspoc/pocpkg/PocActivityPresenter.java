package com.example.akosha.sample1.nucleuspoc.pocpkg;

import android.os.Bundle;

import com.example.akosha.sample1.nucleuspoc.pocpkg.data.MockData;

import nucleus.presenter.RxPresenter;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action2;
import rx.functions.Func0;

/**
 * Created by kushagarlall on 14/01/16.
 */
public class PocActivityPresenter extends RxPresenter<MainPocActivity> {

    /*
    * restartable id(/has to be different for all presenters) for the presenter
    * */
    private static final int REQUEST_ITEMS = 1;
//    private MockData.Employee[] cachedEmployee;
//    private static final String CACHED_EMP = "cache_emp";

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        //// main logic here , to be done in background

        restartableLatestCache(REQUEST_ITEMS,
                new Func0<Observable<MockData>>() {
                    @Override
                    public Observable<MockData> call() {
                        return MockApp.getMockApi()
                                .getMockData().observeOn(AndroidSchedulers.mainThread());
                    }
                },
                new Action2<MainPocActivity, MockData>() {
                    @Override
                    public void call(MainPocActivity activity, MockData response) {
//                        cachedEmployee = response.employees;
                        activity.onItemsNext(response.employees);
                    }
                },
                new Action2<MainPocActivity, Throwable>() {
                    @Override
                    public void call(MainPocActivity activity, Throwable throwable) {
                        activity.onNetworkError(throwable);
                    }
                }
        );

        if (savedState == null) {
            start(REQUEST_ITEMS);
        }
    }

    @Override
    protected void onSave(Bundle state) {
        super.onSave(state);
        //save state or data if required
//        state.putSerializable(CACHED_EMP, cachedEmployee);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void requestPresenter() {
        start(REQUEST_ITEMS);
    }
}
