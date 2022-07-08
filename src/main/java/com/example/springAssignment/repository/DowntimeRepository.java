package com.example.springAssignment.repository;

import com.example.springAssignment.model.Downtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DowntimeRepository extends JpaRepository<Downtime, Long> {

}
