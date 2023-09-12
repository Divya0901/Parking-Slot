package com.dg.PrakingSlot.Controller;

import com.dg.PrakingSlot.DTO.CountResponseDto;
import com.dg.PrakingSlot.Entity.ParkingDetails;
import com.dg.PrakingSlot.Entity.UserParkingDetails;
import com.dg.PrakingSlot.Repository.ParkingDetailsRepository;
import com.dg.PrakingSlot.Repository.UserParkingDetailsRepository;
import com.dg.PrakingSlot.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    ParkingDetailsRepository parkingDetailsRepository;

    @Autowired
    UserParkingDetailsRepository userParkingDetailsRepository;

    @Autowired
    AdminService adminService;

    @GetMapping("/getParkingList")
    public ResponseEntity<List<ParkingDetails>> getParkingList() {
        return new ResponseEntity<>(parkingDetailsRepository.getParkingDetailsList(), HttpStatus.OK);
    }

    @GetMapping("/getUserParkingDetails")
    public ResponseEntity<List<UserParkingDetails>> getUserParkingDetails() {
        return new ResponseEntity<>(userParkingDetailsRepository.getUserParkingDetailsList(), HttpStatus.OK);
    }

    @GetMapping("getCountOfVehicles/{vehicleType}")
    public ResponseEntity<?> getCountOfVehicles(@PathVariable String vehicleType) {
        CountResponseDto countResponseDto = adminService.getCountOfVehicles(vehicleType);
        return new ResponseEntity<>(countResponseDto, HttpStatus.OK);
    }


}
