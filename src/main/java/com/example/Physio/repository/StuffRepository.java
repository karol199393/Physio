package com.example.Physio.repository;

import com.example.Physio.entity.Stuff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StuffRepository extends JpaRepository<Stuff, Long>{
    Stuff findByUsername(String username);
}
