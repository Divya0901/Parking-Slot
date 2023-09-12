package com.dg.PrakingSlot.Controller;

import com.dg.PrakingSlot.DTO.SlotBlockResponse;
import com.dg.PrakingSlot.Entity.UserDetails;
import com.dg.PrakingSlot.Entity.UserParkingDetails;
import com.dg.PrakingSlot.Repository.ParkingDetailsRepository;
import com.dg.PrakingSlot.Repository.UserParkingDetailsRepository;
import com.dg.PrakingSlot.Service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    ParkingDetailsRepository parkingDetailsRepository;

    @Autowired
    UserParkingDetailsRepository userParkingDetailsRepository;

    @PostMapping("/saveUserEntryDetails")
    public ResponseEntity<?> saveUserEntryDetails(@RequestBody UserDetails userDetails) {

        SlotBlockResponse slotBlockResponse = userDetailsService.saveUserEntryDetails(userDetails);
        if(slotBlockResponse==null)
            return new ResponseEntity<>("No slot is Avalabile now", HttpStatus.OK);
        else
            return new ResponseEntity<>(slotBlockResponse, HttpStatus.OK);
    }

    @GetMapping("/saveUserExistDetails/{vehicleId}")
    public UserParkingDetails saveUserExistDetails(@PathVariable String vehicleId) {
        return userDetailsService.saveUserExistDetails(vehicleId);
    }

    @GetMapping("/getAllUserDetails")
    public ResponseEntity<List<UserDetails>> getAllUserDetails() {
        return new ResponseEntity<>(userDetailsService.getAllUserDetails(), HttpStatus.OK);
    }


}
