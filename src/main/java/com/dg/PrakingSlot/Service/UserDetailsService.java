package com.dg.PrakingSlot.Service;

import com.dg.PrakingSlot.Controller.UserController;
import com.dg.PrakingSlot.DTO.AvalabilityDto;
import com.dg.PrakingSlot.DTO.SlotBlockResponse;
import com.dg.PrakingSlot.Entity.BlockDetails;
import com.dg.PrakingSlot.Entity.ParkingDetails;
import com.dg.PrakingSlot.Entity.UserDetails;
import com.dg.PrakingSlot.Entity.UserParkingDetails;
import com.dg.PrakingSlot.Repository.ParkingDetailsRepository;
import com.dg.PrakingSlot.Repository.UserDetailsRepository;
import com.dg.PrakingSlot.Repository.UserParkingDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.JavaInfo;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserDetailsService {

    public static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    ParkingDetailsService parkingDetailsService;

    @Autowired
    UserParkingDetailsRepository userParkingDetailsRepository;

    @Autowired
    ParkingDetailsRepository parkingDetailsRepository;

    public SlotBlockResponse saveUserEntryDetails(UserDetails userDetails) {
        userDetailsRepository.saveUserDetails(userDetails);

        ParkingDetails parkingDetails = parkingDetailsService.getAvailabilityBySlot(1);
        if(!parkingDetails.getAvailability()) {

            if("SUPERBIKE".equalsIgnoreCase(userDetails.getCateogryOfVehicle().toString())) {
                parkingDetails = parkingDetailsService.getAvailabilityBySlot(2);

                if(!parkingDetails.getAvailability())
                    return null;

            } else if ("SCOOTER".equalsIgnoreCase(userDetails.getCateogryOfVehicle().toString())) {
                parkingDetails = parkingDetailsService.getAvailabilityBySlot(3);

                if(!parkingDetails.getAvailability())
                    return null;
            }

            else
                return null;
        }

//        avalabilityDto.getBlockDetails().setAvailability(false);

       parkingDetails.setAvalability(false);

        UserParkingDetails userParkingDetails = new UserParkingDetails();
        userParkingDetails.setUserParkingID(userDetails.getVehicleId());
        userParkingDetails.setUserDetails(userDetails);
//        userParkingDetails.setEntryTime(LocalDateTime.now());
        userParkingDetails.setEntryTime(LocalDateTime.of(2023, 9, 6, 13, 00));
        userParkingDetails.setSlot(parkingDetails.getSlot());
        userParkingDetails.setBlock(parkingDetails.getBlock());

        userParkingDetailsRepository.saveUserParkingDetails(userParkingDetails);

        parkingDetailsService.updateAvailability(parkingDetails);

        return  new SlotBlockResponse(userDetails.getVehicleId(), parkingDetails.getSlot(), parkingDetails.getBlock());
    }

    public UserParkingDetails saveUserExistDetails(String  vehicleId) {
        UserParkingDetails userParkingDetails = null;
        userParkingDetails = userParkingDetailsRepository.getUserParkingDetailsByVehicleId(vehicleId);

        userParkingDetails.setExistTime(LocalDateTime.of(2023, 9, 6, 14, 30));
        Duration durationTime = Duration.between(userParkingDetails.getEntryTime(),userParkingDetails.getExistTime());
//        long hours = durationTime.toHours();
        long minutes = durationTime.toMinutes();
        double amountCalcuated;
        double hours = minutes/60.0;

        if(minutes >= 60){
            if("SCOOTER".equalsIgnoreCase(userParkingDetails.getUserDetails().getCateogryOfVehicle().toString())) {
                amountCalcuated = hours*20.0;
                userParkingDetails.setParkingAmount(amountCalcuated);

            }
            else if("SUPERBIKE".equalsIgnoreCase(userParkingDetails.getUserDetails().getCateogryOfVehicle().toString())){
                amountCalcuated = hours*50.0;
                userParkingDetails.setParkingAmount(amountCalcuated);
            }
            else
                return null;

        }

        ParkingDetails parkingDetails = parkingDetailsRepository.getParkingDetailsBySlotandBlock(userParkingDetails.getSlot(), userParkingDetails.getBlock());
        parkingDetails.setAvalability(true);
        parkingDetailsRepository.updateParkingDetails(parkingDetails);

        return userParkingDetails;
    }

    public List<UserDetails> getAllUserDetails() {
        return userDetailsRepository.getAllUserDetails();
    }
}
