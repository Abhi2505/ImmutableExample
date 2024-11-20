package com.ImmutableExample.ShallowVsDeep;

public class Address implements Cloneable {

    String city;

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", pin=" + pin +
                '}';
    }

    public Address(String city, int pin) {
        this.city = city;
        this.pin = pin;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    int pin;

    @Override
    public Address clone() {
        try {
            Address clone = (Address) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
