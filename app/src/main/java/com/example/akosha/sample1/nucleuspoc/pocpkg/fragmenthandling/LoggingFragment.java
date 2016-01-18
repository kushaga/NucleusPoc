package com.example.akosha.sample1.nucleuspoc.pocpkg.fragmenthandling;

import android.os.Bundle;
import android.view.View;

import nucleus.view.NucleusSupportFragment;
import nucleus.presenter.Presenter;

import static android.util.Log.v;

/**
 * Created by kushagarlall on 14/01/16.
 */
public class LoggingFragment<PresenterType extends Presenter> extends NucleusSupportFragment<PresenterType> {

    private final String TAG = getClass().getSimpleName();

    public LoggingFragment() {
        v(TAG, "constructor");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        v(TAG, "onCreate " + savedInstanceState);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        v(TAG, "onDestroy");
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        v(TAG, "onSaveInstanceState " + bundle);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        v(TAG, "onViewCreated");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        v(TAG, "onDestroyView");
    }

    @Override
    public void onResume() {
        super.onResume();
        v(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        v(TAG, "onPause");
    }
}
