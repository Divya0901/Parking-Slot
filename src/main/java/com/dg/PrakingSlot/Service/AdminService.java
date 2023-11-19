package com.dg.PrakingSlot.Service;

import com.dg.PrakingSlot.Controller.UserController;
import com.dg.PrakingSlot.DTO.CountResponseDto;
import com.dg.PrakingSlot.Repository.UserDetailsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    public static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserDetailsRepository userDetailsRepository;

    public CountResponseDto getCountOfVehicles(String vehicleType) {
        CountResponseDto countResponseDto = new CountResponseDto();

        try {
            logger.info("AdminService :: getCountOfVehicles() started");
            Integer count = userDetailsRepository.findUserByCategoryOfVehicle(vehicleType);

            countResponseDto.setMessage("Data fetched");
            countResponseDto.setCount(count);

            logger.info("Count of vehicles for type '{}' retrieved successfully: {}", vehicleType, count);
        } catch (Exception e) {
            logger.error("Error occurred while fetching count of vehicles for type '{}'", vehicleType, e);
            countResponseDto.setMessage("Error occurred while fetching data");
        }

        return countResponseDto;
    }
}


