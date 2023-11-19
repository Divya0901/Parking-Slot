package com.dg.PrakingSlot.Service;

import com.dg.PrakingSlot.Controller.UserController;
import com.dg.PrakingSlot.Entity.*;
import com.dg.PrakingSlot.Repository.ParkingDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingDetailsService {

    public static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private ParkingDetailsRepository parkingDetailsRepository;

    public ParkingDetails getAvailabilityBySlot(int slot) {
        logger.info("ParkingDetailsService :: getAvailabilityBySlot() started");
            try {
                List<ParkingDetails> parkingDetailsList = parkingDetailsRepository.getParkingDetailsBySlot(slot);

                for (ParkingDetails parkingDetails : parkingDetailsList) {
                    if (parkingDetails.getAvailability()) {
                        logger.info("Parking slot {} is available. Returning details: {}", slot, parkingDetails);
                        return parkingDetails;
                    }
                }

                logger.info("No available parking details found for slot {}", slot);
                return null;
            } catch (Exception e) {
                logger.error("Error occurred while fetching parking details for slot {}", slot, e);
                return null;
            }
        }

    public void updateAvailability(ParkingDetails parkingDetails) {
        logger.info("ParkingDetailsService :: updateAvailability() started");
        try {
            parkingDetailsRepository.updateParkingDetails(parkingDetails);
            logger.info("Parking details updated successfully: {}", parkingDetails);
        } catch (Exception e) {
            logger.error("Error occurred while updating parking details: {}", parkingDetails, e);
        }
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
