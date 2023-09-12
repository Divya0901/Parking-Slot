package com.dg.PrakingSlot.Entity;


public class BlockDetails {

    private String block;
    private Boolean availability;

    public BlockDetails() {
    }

    public BlockDetails(String block, Boolean availability) {
        this.block = block;
        this.availability = availability;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "BlockDetails{" +
                "block='" + block + '\'' +
                ", availability=" + availability +
                '}';
    }
}
