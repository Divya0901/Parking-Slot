package com.dg.PrakingSlot.Entity;

import java.util.List;

public class ParkingDetails {

    private Integer slot;

    private String block;

    private boolean availability;


    public ParkingDetails() {
    }

    @Override
    public String toString() {
        return "ParkingDetails{" +
                "slot=" + slot +
                ", block='" + block + '\'' +
                ", availability=" + availability +
                '}';
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setAvalability(boolean avalability) {
        this.availability = avalability;
    }

    public ParkingDetails(Integer slot, String block, boolean avalability) {
        this.slot = slot;
        this.block = block;
        this.availability = avalability;
    }
}
