package com.ImmutableExample.ShallowVsDeep;

public class Student implements Cloneable{
    int id;
    String name;
    Address ad;

    public Student(int id, String name, Address ad) {
        this.id = id;
        this.name = name;
        this.ad = ad;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ad=" + ad +
                '}';
    }


    public Address getAd() {
        return ad;
    }

    public void setAd(Address ad) {
        this.ad = ad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Student clone() {
        try {

            Student clone = (Student) super.clone();
            clone.ad=(Address) ad.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
