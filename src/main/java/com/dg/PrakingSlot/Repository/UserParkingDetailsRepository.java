package com.dg.PrakingSlot.Repository;

import com.dg.PrakingSlot.Entity.UserParkingDetails;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserParkingDetailsRepository {

    private List<UserParkingDetails> userParkingDetailsList = new ArrayList<>();

    public UserParkingDetails getUserParkingDetailsByVehicleId(String vehicleId) {
        for(UserParkingDetails userParkingDetails:userParkingDetailsList){
            if(userParkingDetails.getUserDetails().getVehicleId().equalsIgnoreCase(vehicleId))
                return userParkingDetails;
        }
        return null;
    }

    public void saveUserParkingDetails(UserParkingDetails userParkingDetails) {
        userParkingDetailsList.add(userParkingDetails);
    }

    public List<UserParkingDetails> getUserParkingDetailsList() {
        return userParkingDetailsList;
    }
}
