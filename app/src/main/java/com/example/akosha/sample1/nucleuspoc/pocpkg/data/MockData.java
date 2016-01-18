package com.example.akosha.sample1.nucleuspoc.pocpkg.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by kushagarlall on 14/01/16.
 */

/*
*  use this mock data to handle server incoming mock data
* */
public class MockData implements Serializable {

    public class Employee implements Serializable {
        @SerializedName("firstName")
        public String firstName;
        @SerializedName("lastName")
        public String lastName;
    }

    @SerializedName("employees")
    public Employee[] employees;
}
