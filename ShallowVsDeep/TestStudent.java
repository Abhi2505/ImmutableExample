package com.ImmutableExample.ShallowVsDeep;

import java.util.HashMap;

public class TestStudent {

    public static void main(String[] args) {
        Address ad=new Address("bhopal",462042);
        Student st1=new Student(1,"abhi",ad);
        //Student st2=st1;
        //st1.setId(2);
       // System.out.println(st1+" ------- "+ st2);
        //here for above example actually s1 and s2 are pointing tp the same reference so modifying in one means modiying in other also
        //The above is called as reference copying ...To prevent this changing in one should not change in other we can use object cloning
        //In cloning approach for primitive data types a new copy is created but for object field the cloned object
        //is having the same reference as the original object
        Student st2= (Student) st1.clone();
        st1.setId(2);
        st1.setName("ram");
        st1.getAd().setCity("kota"); //siince addres is an object so for it reference copying occurs during cloning in cloned student object
        ad.setCity("noida");
        //to prevent above we have to do the deep cloning means while clonging student clone addreess and asign to student
        //so now address in the clone student becomes independent of original student address .
        //now we cant change address of st2 while changing st1 addrees using get and set as it is independent
        //also we cant change st2 address while changing st1 address reference now for the same reason.
        System.out.println(st1+" ------- "+ st2);
  }
}
