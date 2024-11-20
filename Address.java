package com.ImmutableExample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//for a class to clone it should be cloneable otherwise it will give clonenotsupported exception
public class Address implements Cloneable
       {
    private String street;
    private String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }
           public Object clone() throws CloneNotSupportedException {
               return super.clone();
           }
    public String getStreet() {
        return street;
    }

    @Override
    public String toString() {
        return "{Street: " + street + ", City: " + city + "}";
    }

    public String getCity() {
        return city;
    }
    public void setStreet(String street) {
        this.street = street;

    }
    public void setCity(String city) {
        this.city = city;
    }


}
