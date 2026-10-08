package com.example.timesheet.controller;

import com.example.timesheet.dto.StatusUpdateRequest;
import com.example.timesheet.dto.TimesheetRequest;
import com.example.timesheet.entity.Timesheet;
import com.example.timesheet.service.TimesheetService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timesheets")
@CrossOrigin(origins = "http://localhost:5175")
public class TimesheetController {

    private final TimesheetService timesheetService;

    // Manual constructor - no Lombok required
    public TimesheetController(TimesheetService timesheetService) {
        this.timesheetService = timesheetService;
    }

    // CREATE TIMESHEET
    @PostMapping
    public ResponseEntity<Timesheet> createTimesheet(
            @Valid @RequestBody TimesheetRequest request) {

        return ResponseEntity.ok(
                timesheetService.createTimesheet(request)
        );
    }

    // GET ALL TIMESHEETS
    @GetMapping
    public ResponseEntity<List<Timesheet>> getAllTimesheets() {

        return ResponseEntity.ok(
                timesheetService.getAllTimesheets()
        );
    }

    // UPDATE STATUS
    @PutMapping("/{id}/status")
    public ResponseEntity<Timesheet> updateStatus(
            @PathVariable Long id,
            @Valid @RequestBody StatusUpdateRequest request) {

        return ResponseEntity.ok(
                timesheetService.updateStatus(
                        id,
                        request.getStatus()
                )
        );
    }
}