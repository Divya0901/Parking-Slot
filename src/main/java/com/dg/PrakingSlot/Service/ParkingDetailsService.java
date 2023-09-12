package com.dg.PrakingSlot.Service;

import com.dg.PrakingSlot.DTO.AvalabilityDto;
import com.dg.PrakingSlot.Entity.*;
import com.dg.PrakingSlot.Repository.ParkingDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingDetailsService {

    @Autowired
    private ParkingDetailsRepository parkingDetailsRepository;

    public ParkingDetails getAvalaibilityBySlot(int slot) {
        AvalabilityDto avalabilityDto = new AvalabilityDto();

        List<ParkingDetails> parkingDetailsList = parkingDetailsRepository.getParkingDetailsBySlot(slot);
        for(ParkingDetails parkingDetails : parkingDetailsList) {
            if(parkingDetails.getAvalability()) {
                return parkingDetails;
            }
        }
        return null;
    }

    public void updateAvaliblity(ParkingDetails parkingDetails) {

        parkingDetailsRepository.updateParkingDetails(parkingDetails);
    }

//    public void updateAvaliblity(ParkingDetails parkingDetails, BlockDetails blockDetails) {
//
//        List<BlockDetails> blockDetailsList = new ArrayList<>();
//
//        for(BlockDetails blockDetails1:parkingDetails.getBlockDetailsList()) {
//            if(blockDetails1.getBlock().equalsIgnoreCase(blockDetails.getBlock())) {
//                blockDetails1.setAvailability(blockDetails.getAvailability());
//            }
//            blockDetailsList.add(blockDetails1);
//        }
//        parkingDetails.setBlockDetailsList(blockDetailsList);
//        parkingDetailsRepository.updateParkingDetails(parkingDetails);
//    }



//    @Autowired
//    private final SlotSystem slotSystem;
//
//    public ParkingDetailsService(SlotSystem slotSystem) {
//        this.slotSystem = slotSystem;
//    }
//
//    public boolean updateSlotItem(String slotName, String blockName, String item) {
//        return slotSystem.addItem(slotName, blockName, item);
//    }
//
//    public boolean isBlockOccupied(String slotName, String blockName) {
//        return slotSystem.isOccupied(slotName, blockName);
//    }
//
//    public Slot getSlot(String slotName) {
//        return slotSystem.getSLot(slotName);
//    }
//
//    public Block getBlock(String slotName, String blockName) {
//        return slotSystem.getBlockDetails(slotName,blockName);
//    }
}
