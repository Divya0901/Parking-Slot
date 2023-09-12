package com.dg.PrakingSlot.DTO;

public class SlotBlockResponse {

    private String vehicleId;
    private int slot;
    private String block;

    public SlotBlockResponse(String vehicleId, int slot, String block) {
        this.vehicleId = vehicleId;
        this.slot = slot;
        this.block = block;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
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

    @Override
    public String toString() {
        return "SlotBlockResponse{" +
                "vehicleId='" + vehicleId + '\'' +
                ", slot=" + slot +
                ", block='" + block + '\'' +
                '}';
    }
}
