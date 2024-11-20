package com.ImmutableExample;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
// Steps
//if u r having only primitive data type then shallow cloning is prefered if u have nested objects along then
//u have to perform deep cloning
//Declare class as final.
//Make all properties as private final.
//Do not declare setters. Only getters.
//Declare all args constructor.
//If there are custom nested objects in the class as properties,implement clone.
//If there are other types of nested objects as properties, perform a deep copy.

//until we do not have a nested object then all primitive are cloned but once nested is there and clone is used then
//same referenced one is copied  and modifying one would change other also
//so to prevent this u have to override the clone methodn
public final class Employee {
    //if we put the student feature in this class
    private final String empName;
    private final int age;



    private final Address address;
    private final List<String> phoneNumbers;
    private final Map<String, String> metadata;

    public String getEmpName() {
        return empName;
    }

    public int getAge() {
        return age;
    }

//    public Address getAddress() {
//        return address;
//    }
    //clone the address object
public Address getAddress() throws CloneNotSupportedException {
     return (Address) address.clone();
}

//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//      Address ad=new Address("Kolar","Bhopal");
//      List<String>phoneNumbers=new ArrayList<>(getPhoneNumbers());
//      HashMap<String,String>metadata=new HashMap<>(getMetadata());
//      Employee emp=new Employee(empName,age,ad,phoneNumbers,metadata);
//      return emp;
//    }

    public List<String> getPhoneNumbers() {
//        return phoneNumbers;
        // deep copy the list of phone numbers ye islie krna pdega in getter so that immutability bni rhi otherwise
        //koi is phonenumber list ko get krke modify kr dega but since new arraylist return kra toh purana wont change
        return new ArrayList<>(phoneNumbers);

    }

    @Override
    public String toString() {
        return "Employee{" +
                "empName='" + empName + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", phoneNumbers=" + phoneNumbers +
                ", metadata=" + metadata +
                '}';
    }

    public Map<String, String> getMetadata() {
//       return metadata;
        // deep copy the map of metadata
        return new HashMap<>(metadata);
    }

    public Employee(String empName, int age, Address address, List<String> phoneNumbers, Map<String, String> metadata) {
        this.empName = empName;
        this.age = age;
        this.address = new Address( address.getStreet(),address.getCity());
        this.phoneNumbers = new ArrayList<>(phoneNumbers);
        this.metadata =new HashMap<>(metadata) ;
    }

    //make class as final so that it canot be overided and make all prop as private
    //so that they are not visible outside the class
    //when make all prop as final they must be assigned values within the constructor
    public static void main(String[] args) throws CloneNotSupportedException {
        ConcurrentHashMap<String,Integer>h=new ConcurrentHashMap<>();
        h.put(null,2);
        h.put("sa",null);
        HashMap<String,String>h2=new HashMap<>();
        Map<String,String>map=Collections.synchronizedMap(h2);
        map.put(null,"sd");
        map.put("ss",null);
//        String s1="ahs";
//        System.out.println(s1.hashCode()+" "+s1);
//          Strings are immutable if u modiy it creates a new object
//        s1=s1+"as";
//        System.out.println(s1.hashCode()+ " "+s1);


        Address address = new Address("street 1", "city X");
       List<String> phoneNumbers = new ArrayList<>();
        System.out.println(address+" ---------1");

        phoneNumbers.add("123456");
        phoneNumbers.add("456789");
        Map<String, String> metadata = new HashMap<>();
        metadata.put("hobby", "Watching Movies");
        Employee e = new Employee("John", 23, address, phoneNumbers, metadata);
        phoneNumbers.add("2313213");
      // Employee e2=(Employee) e.clone();
       //System.out.println(e2);
        System.out.println(e+" before modification ");
        address.setStreet("sdade");
        System.out.println(address+" ---------------2");
        e.getPhoneNumbers().add("Ss21");
        e.getPhoneNumbers().add("98282922");
        e.getMetadata().put("skill", "Java");
        e.getMetadata().put("designation", "HR");
        //for an object to get clone it should implement cloneable interface to prevent clonenotsupported exc
        //if we create via above way then we will get shallow cloning if we want deep cloning then we need to override
        //the emp object;
        System.out.println(e.getAddress().hashCode()+" ---------2");

//        e.getAddress().setCity("c3");
//        e.getAddress().setStreet("s3");
//       //here we can see that list and map got updated hence immutablity(1) broken
        //so here we have to modify the geeters to get the old data we have to take
        //copy of existing data assigned using constructor and return as a new object
        System.out.println(e+"After modification");

    }
}

