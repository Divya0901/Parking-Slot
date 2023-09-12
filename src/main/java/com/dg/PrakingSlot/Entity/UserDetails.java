package com.dg.PrakingSlot.Entity;

import org.springframework.stereotype.Component;

@Component
public class UserDetails {

    private String name;
    private String phoneNumber;
    private String vehicleId;
    private CateogryOfVehicle cateogryOfVehicle;

    public UserDetails() {}

    public UserDetails(String name, String phoneNumber, String vehicleId, CateogryOfVehicle cateogryOfVehicle) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.vehicleId = vehicleId;
        this.cateogryOfVehicle = cateogryOfVehicle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public CateogryOfVehicle getCateogryOfVehicle() {
        return cateogryOfVehicle;
    }

    public void setCateogryOfVehicle(CateogryOfVehicle cateogryOfVehicle) {
        this.cateogryOfVehicle = cateogryOfVehicle;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", vehicleId='" + vehicleId + '\'' +
                ", cateogryOfVehicle=" + cateogryOfVehicle +
                '}';
    }
}
