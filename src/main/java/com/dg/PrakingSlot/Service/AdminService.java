package com.dg.PrakingSlot.Service;

import com.dg.PrakingSlot.DTO.CountResponseDto;
import com.dg.PrakingSlot.Entity.CateogryOfVehicle;
import com.dg.PrakingSlot.Repository.UserDetailsRepository;
import com.dg.PrakingSlot.Repository.UserParkingDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    public CountResponseDto getCountOfVehicles(String vehicleType) {
        CountResponseDto countResponseDto = new CountResponseDto();
        Integer count =  userDetailsRepository.findUserByCateogryOfVehicle(vehicleType);

        countResponseDto.setMessage("Data fecthed");
        countResponseDto.setCount(count);

        return countResponseDto;
    }
}
