package com.dg.PrakingSlot.DTO;

import com.dg.PrakingSlot.Entity.BlockDetails;
import com.dg.PrakingSlot.Entity.ParkingDetails;
import com.dg.PrakingSlot.Entity.UserParkingDetails;

public class AvalabilityDto {

    private ParkingDetails parkingDetails;
    private String block;

    private boolean avalability;

    public AvalabilityDto() {
    }

    public AvalabilityDto(ParkingDetails parkingDetails, String block, boolean avalability) {
        this.parkingDetails = parkingDetails;
        this.block = block;
        this.avalability = avalability;
    }

    public ParkingDetails getParkingDetails() {
        return parkingDetails;
    }

    public void setParkingDetails(ParkingDetails parkingDetails) {
        this.parkingDetails = parkingDetails;
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

    @Override
    public String toString() {
        return "AvalabilityDto{" +
                "parkingDetails=" + parkingDetails +
                ", block=" + block +
                ", avalability=" + avalability +
                '}';
    }
}
