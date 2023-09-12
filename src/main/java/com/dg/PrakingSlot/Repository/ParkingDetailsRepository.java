package com.dg.PrakingSlot.Repository;

import com.dg.PrakingSlot.Entity.BlockDetails;
import com.dg.PrakingSlot.Entity.ParkingDetails;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Repository
public class ParkingDetailsRepository {

    private List<ParkingDetails> parkingDetailsList = new ArrayList<>();

    public void loadParkingDetails() {
//        BlockDetails blockDetailsA = new BlockDetails("A", true);
//        BlockDetails blockDetailsB = new BlockDetails("B", true);
//        BlockDetails blockDetailsC = new BlockDetails("C", true);
//
//        List<BlockDetails> blockDetailsList = new ArrayList<>();
//        blockDetailsList.add(blockDetailsA);
//        blockDetailsList.add(blockDetailsB);
//        blockDetailsList.add(blockDetailsC);


        ParkingDetails parkingDetails1A = new ParkingDetails(1, "A",true);
        ParkingDetails parkingDetails1B = new ParkingDetails(1, "B",true);
        ParkingDetails parkingDetails1C = new ParkingDetails(1, "C",true);
        ParkingDetails parkingDetails2A = new ParkingDetails(2, "A",true);
        ParkingDetails parkingDetails2B = new ParkingDetails(2, "B",true);
        ParkingDetails parkingDetails2C = new ParkingDetails(2, "C",true);
        ParkingDetails parkingDetails3A = new ParkingDetails(3, "A",true);
        ParkingDetails parkingDetails3B = new ParkingDetails(3, "B",true);
        ParkingDetails parkingDetails3C = new ParkingDetails(3, "C",true);

        parkingDetailsList.add(parkingDetails1A);
        parkingDetailsList.add(parkingDetails1B);
        parkingDetailsList.add(parkingDetails1C);
        parkingDetailsList.add(parkingDetails2A);
        parkingDetailsList.add(parkingDetails2B);
        parkingDetailsList.add(parkingDetails2C);
        parkingDetailsList.add(parkingDetails3A);
        parkingDetailsList.add(parkingDetails3B);
        parkingDetailsList.add(parkingDetails3C);
    }

    public List<ParkingDetails> getParkingDetailsBySlot(int slot) {
//        for(ParkingDetails parkingDetails : parkingDetailsList){
//            if(parkingDetails.getSlot()==slot)
//                return parkingDetails;
//        }
//        return null;

        return parkingDetailsList.stream().filter(parkingDetails -> parkingDetails.getSlot()==slot).collect(Collectors.toList());

//        Note: For each loop used to iterate or printvalue, but use stream.filter method to return any value.
    }

    public void updateParkingDetails(ParkingDetails parkingDetails) {
        ParkingDetails parkingDetails3 = null;
        
        for(ParkingDetails parkingDetails1 : parkingDetailsList) {
            if(parkingDetails1.getSlot()==parkingDetails.getSlot() && parkingDetails1.getBlock().equalsIgnoreCase(parkingDetails.getBlock())){
               parkingDetails3 = parkingDetails1;
            }
        }
        parkingDetailsList.remove(parkingDetails3);
        parkingDetailsList.add(parkingDetails);
    }

    public List<ParkingDetails> getParkingDetailsList() {
        return parkingDetailsList;
    }

    public ParkingDetails getParkingDetailsBySlotandBlock(int slot, String block) {

        for(ParkingDetails parkingDetails:parkingDetailsList) {
            if(parkingDetails.getSlot().equals(slot) && parkingDetails.getBlock().equalsIgnoreCase(block)) {
                return parkingDetails;
            }
        }
//        return parkingDetailsList.stream().filter(parkingDetails -> Objects.equals(parkingDetails.getSlot(), slot) && Objects.equals(parkingDetails.getBlock(), block))
//                .findFirst().orElse(null);

        return null;
    }
}
