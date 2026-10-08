package com.example.timesheet.repository;

import com.example.timesheet.entity.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TimesheetRepository extends JpaRepository<Timesheet, Long> {
    List<Timesheet> findAllByOrderByWorkDateDescCreatedAtDesc();
    List<Timesheet> findByUsernameOrderByWorkDateDesc(String username);
}