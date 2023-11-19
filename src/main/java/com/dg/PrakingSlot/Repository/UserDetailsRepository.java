package com.dg.PrakingSlot.Repository;

import com.dg.PrakingSlot.Entity.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDetailsRepository {

    List<UserDetails> userDetailsList = new ArrayList<>();
    public void saveUserDetails(UserDetails userDetails) {
        this.userDetailsList.add(userDetails);
    }

    public List<UserDetails> getAllUserDetails() {
        return this.userDetailsList;
    }

    public UserDetails findUserByVehicleId(String vehicleId) {
        for(UserDetails userDetails: userDetailsList) {
            if(userDetails.getVehicleId() == vehicleId)
                return userDetails;
        }
        return null;
    }

    public Integer findUserByCategoryOfVehicle(String vehicleType) {
        int count = 0;
        for(UserDetails userDetails: userDetailsList) {
            if(userDetails.getCateogryOfVehicle().toString().equalsIgnoreCase(vehicleType)) {
                count++;
            }
        }
        return count;
    }
}
