package com.example.timesheet.service;

import com.example.timesheet.dto.TimesheetRequest;
import com.example.timesheet.entity.Timesheet;
import com.example.timesheet.repository.TimesheetRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimesheetService {

    private final TimesheetRepository repository;

    // Constructor injection
    public TimesheetService(TimesheetRepository repository) {
        this.repository = repository;
    }

    public Timesheet createTimesheet(TimesheetRequest request) {

        Timesheet sheet = new Timesheet();

        sheet.setUsername(request.getUsername());
        sheet.setWorkDate(request.getWorkDate());
        sheet.setFromTime(request.getFromTime());
        sheet.setToTime(request.getToTime());
        sheet.setDuration(request.getDuration());
        sheet.setDescription(request.getDescription());
        sheet.setStatus(Timesheet.Status.PENDING);

        return repository.save(sheet);
    }

    public List<Timesheet> getAllTimesheets() {

        return repository.findAllByOrderByWorkDateDescCreatedAtDesc();
    }

    public Timesheet updateStatus(Long id, Timesheet.Status status) {

        Timesheet sheet = repository.findById(id)
                .orElseThrow(() ->
                    new RuntimeException(
                        "Timesheet not found with ID: " + id
                    )
                );

        sheet.setStatus(status);

        return repository.save(sheet);
    }
}