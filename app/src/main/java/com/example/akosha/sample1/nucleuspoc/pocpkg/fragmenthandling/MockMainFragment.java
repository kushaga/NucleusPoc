package com.example.akosha.sample1.nucleuspoc.pocpkg.fragmenthandling;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import nucleus.factory.RequiresPresenter;

/**
 * Created by kushagarlall on 14/01/16.
 */
@RequiresPresenter(MockFragPresenter.class)
public class MockMainFragment extends LoggingFragment<MockFragPresenter> {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //handle views & attach presenter
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
