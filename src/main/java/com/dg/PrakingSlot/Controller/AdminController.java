package com.dg.PrakingSlot.Controller;

import com.dg.PrakingSlot.DTO.CountResponseDto;
import com.dg.PrakingSlot.Entity.ParkingDetails;
import com.dg.PrakingSlot.Entity.UserParkingDetails;
import com.dg.PrakingSlot.Repository.ParkingDetailsRepository;
import com.dg.PrakingSlot.Repository.UserParkingDetailsRepository;
import com.dg.PrakingSlot.Service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {

    public static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    @Autowired
    ParkingDetailsRepository parkingDetailsRepository;

    @Autowired
    UserParkingDetailsRepository userParkingDetailsRepository;

    @Autowired
    AdminService adminService;

    @GetMapping("/getParkingList")
    public ResponseEntity<List<ParkingDetails>> getParkingList() {

        try {
            logger.info("AdminController :: getParkingList() started ");
            List<ParkingDetails> parkingDetailsList = parkingDetailsRepository.getParkingDetailsList();

            if(parkingDetailsList.isEmpty()) {
                logger.debug("No parking list details found");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                logger.debug("Returning {} parking list details in the response", parkingDetailsList.size());
                return new ResponseEntity<>(parkingDetailsList, HttpStatus.OK);
            }
        } catch(Exception e) {
            logger.error("Error in AdminController :: getParkingList(): {}", e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/getUserParkingDetails")
    public ResponseEntity<List<UserParkingDetails>> getUserParkingDetails() {

        try {
            logger.info("AdminController :: getUserParkingDetails() started ");
            List<UserParkingDetails> userParkingDetailsList = userParkingDetailsRepository.getUserParkingDetailsList();

            if(userParkingDetailsList.isEmpty()) {
                logger.debug("No user parking details found");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                logger.debug("Returning {} user parking details in the response");
                return new ResponseEntity<>(userParkingDetailsList, HttpStatus.OK);
            }
        } catch (Exception e) {
         logger.error("Error in AdminController :: getUserParkingDetails(): {}\", e.getMessage(), e")   ;
         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("getCountOfVehicles/{vehicleType}")
    public ResponseEntity<?> getCountOfVehicles(@PathVariable String vehicleType) {

        try {
            logger.info("AdminController :: getCountOfVehicles() started for vehicleType: {}", vehicleType);

            CountResponseDto countResponseDto = adminService.getCountOfVehicles(vehicleType);

            if(countResponseDto != null) {
                logger.debug("Returning count for vehicleType '{}': {}", vehicleType, countResponseDto.getCount());
                return new ResponseEntity<>(countResponseDto, HttpStatus.OK);
            } else {
                logger.info("No data found for vehicleType: {}", vehicleType);
                return new ResponseEntity<>("No data found for the provided vehicle type", HttpStatus.NO_CONTENT);
            }
        } catch (IllegalArgumentException e) {
            logger.error("Invalid vehicle type provided: {}", vehicleType, e);
            return new ResponseEntity<>("Invalid vehicle type provided", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            logger.error("An error occurred while processing the request for vehicleType: {}", vehicleType, e);
            return new ResponseEntity<>("An error occurred while processing the request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
