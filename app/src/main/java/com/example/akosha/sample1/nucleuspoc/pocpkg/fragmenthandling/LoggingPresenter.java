package com.example.akosha.sample1.nucleuspoc.pocpkg.fragmenthandling;

import android.os.Bundle;

import nucleus.presenter.RxPresenter;

import static android.util.Log.v;

/**
 * Created by kushagarlall on 14/01/16.
 */
public class LoggingPresenter<ViewType> extends RxPresenter<ViewType> {

    private final String TAG = getClass().getSimpleName();

    public LoggingPresenter() {
        v(TAG, "constructor");
    }

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
        v(TAG, "onCreate");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        v(TAG, "onDestroy");
    }

    @Override
    protected void onSave(Bundle state) {
        super.onSave(state);
        v(TAG, "onSave");
    }

    @Override
    protected void onTakeView(ViewType view) {
        super.onTakeView(view);
        v(TAG, "onTakeView");
    }

    @Override
    protected void onDropView() {
        super.onDropView();
        v(TAG, "onDropView");
    }
}
