package com.example.traveler.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.traveler.Model.Traveler;
import com.example.traveler.Repository.TravelerRepo;

@CrossOrigin("*")
@RestController
@RequestMapping("/traveler")
public class TravelerController {
    
    @Autowired
    private TravelerRepo travelerrepo;

    @PostMapping("/add")
    public String addTraveler(@RequestBody Traveler traveler){
        travelerrepo.save(traveler);
        return "Traveler's info has been Stored";
    }


}
