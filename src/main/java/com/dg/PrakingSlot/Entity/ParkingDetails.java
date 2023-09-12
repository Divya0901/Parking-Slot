package com.dg.PrakingSlot.Entity;

import java.util.List;

public class ParkingDetails {

    private Integer slot;

    private String block;

    private boolean avalability;


    public ParkingDetails() {
    }

    @Override
    public String toString() {
        return "ParkingDetails{" +
                "slot=" + slot +
                ", block='" + block + '\'' +
                ", avalability=" + avalability +
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

    public boolean getAvalability() {
        return avalability;
    }

    public void setAvalability(boolean avalability) {
        this.avalability = avalability;
    }

    public ParkingDetails(Integer slot, String block, boolean avalability) {
        this.slot = slot;
        this.block = block;
        this.avalability = avalability;
    }
}
