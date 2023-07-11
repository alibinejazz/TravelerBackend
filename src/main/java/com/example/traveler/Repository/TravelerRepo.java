package com.example.traveler.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.traveler.Model.Traveler;

public interface TravelerRepo extends JpaRepository<Traveler, Long>{
    
}
