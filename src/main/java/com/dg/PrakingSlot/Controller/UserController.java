package com.dg.PrakingSlot.Controller;

import com.dg.PrakingSlot.DTO.SlotBlockResponse;
import com.dg.PrakingSlot.Entity.UserDetails;
import com.dg.PrakingSlot.Entity.UserParkingDetails;
import com.dg.PrakingSlot.Service.UserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

   public static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserDetailsService userDetailsService;

    @PostMapping("/saveUserEntryDetails")
    public ResponseEntity<?> saveUserEntryDetails(@RequestBody UserDetails userDetails) {
        try {
            logger.info("UserController :: saveUserEntryDetails() started");

            if (userDetails == null) {
                logger.error("Received null UserDetails in saveUserEntryDetails()");
                return new ResponseEntity<>("Invalid user details", HttpStatus.BAD_REQUEST);
            }

            SlotBlockResponse slotBlockResponse = userDetailsService.saveUserEntryDetails(userDetails);

            if (slotBlockResponse == null) {
                logger.debug("No slot is available now");
                return new ResponseEntity<>("No slot is available now", HttpStatus.OK);
            } else {
                logger.debug("User details saved successfully");
                return new ResponseEntity<>(slotBlockResponse, HttpStatus.OK);
            }
        } catch (Exception e) {
            logger.error("Error in saveUserEntryDetails()", e);
            return new ResponseEntity<>("An error occurred while processing the request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/saveUserExistDetails/{vehicleId}")
//    public UserParkingDetails saveUserExistDetails(@PathVariable String vehicleId) {
//        return userDetailsService.saveUserExistDetails(vehicleId);

        public UserParkingDetails saveUserExistDetails(@PathVariable String vehicleId) {
            try {
                logger.info("UserController :: saveUserExistDetails() started with vehicleId: {}", vehicleId);

                if (vehicleId == null || vehicleId.isEmpty()) {
                    logger.error("Invalid vehicleId provided in saveUserExistDetails()");
                    return null;
                }

                UserParkingDetails userParkingDetails = userDetailsService.saveUserExistDetails(vehicleId);

                if (userParkingDetails == null) {
                    logger.debug("No user parking details found for vehicleId: {}", vehicleId);
                } else {
                    logger.debug("User parking details retrieved successfully for vehicleId: {}", vehicleId);
                }
                return userParkingDetails;
            } catch (Exception e) {
                logger.error("Error in saveUserExistDetails() with vehicleId: {}", vehicleId, e);
                throw new RuntimeException("An error occurred while processing the request");
            }
        }

    @GetMapping("/getAllUserDetails")
//    public ResponseEntity<List<UserDetails>> getAllUserDetails() {
//        return new ResponseEntity<>(userDetailsService.getAllUserDetails(), HttpStatus.OK);

        public ResponseEntity<List<UserDetails>> getAllUserDetails() {
            try {
                logger.info("UserController :: getAllUserDetails() started");

                List<UserDetails> userDetailsList = userDetailsService.getAllUserDetails();

                if (userDetailsList == null || userDetailsList.isEmpty()) {
                    logger.info("No user details found");
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                } else {
                    logger.info("Retrieved {} user details", userDetailsList.size());
                    return new ResponseEntity<>(userDetailsList, HttpStatus.OK);
                }
            } catch (Exception e) {
                logger.error("Error in getAllUserDetails()", e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

