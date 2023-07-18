package com.java.Project.Entity;

import javax.persistence.*;

@Entity
public class Address {

    public Address(){

    }
    public Address(String street_Name,String place){
        super();
        this.street_Name = street_Name ;
        this.place = place ;
    }
    @Override
    public String toString() {
        return "Address{" +
                "house_Number=" + house_Number +
                ", street_Name='" + street_Name + '\'' +
                ", place='" + place + '\'' +
                '}';
    }

    public int getHouse_Number() {
        return house_Number;
    }

    public void setHouse_Number(int house_Number) {
        this.house_Number = house_Number;
    }

    public String getStreet_Name() {
        return street_Name;
    }

    public void setStreet_Name(String street_Name) {
        this.street_Name = street_Name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int house_Number;
    String street_Name ;
    String place ;

}
