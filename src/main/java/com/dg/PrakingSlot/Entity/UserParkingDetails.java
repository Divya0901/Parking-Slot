package com.dg.PrakingSlot.Entity;

import java.time.LocalDateTime;

public class UserParkingDetails {

    private String userParkingID;

    private UserDetails userDetails;

    private LocalDateTime entryTime;

    private LocalDateTime existTime;

    private int slot;
    private String block;

    private Double parkingAmount;

    public UserParkingDetails() {
    }

    public UserParkingDetails(String userParkingID, UserDetails userDetails, LocalDateTime entryTime, LocalDateTime existTime, int slot, String block, Double parkingAmount) {
        this.userParkingID = userParkingID;
        this.userDetails = userDetails;
        this.entryTime = entryTime;
        this.existTime = existTime;
        this.slot = slot;
        this.block = block;
        this.parkingAmount = parkingAmount;
    }

    public String getUserParkingID() {
        return userParkingID;
    }

    public void setUserParkingID(String userParkingID) {
        this.userParkingID = userParkingID;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalDateTime getExistTime() {
        return existTime;
    }

    public void setExistTime(LocalDateTime existTime) {
        this.existTime = existTime;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public Double getParkingAmount() {
        return parkingAmount;
    }

    public void setParkingAmount(Double parkingAmount) {
        this.parkingAmount = parkingAmount;
    }

    @Override
    public String toString() {
        return "UserParkingDetails{" +
                "userParkingID='" + userParkingID + '\'' +
                ", userDetails=" + userDetails +
                ", entryTime=" + entryTime +
                ", existTime=" + existTime +
                ", slot=" + slot +
                ", block=" + block +
                ", parkingAmount=" + parkingAmount +
                '}';
    }
}
