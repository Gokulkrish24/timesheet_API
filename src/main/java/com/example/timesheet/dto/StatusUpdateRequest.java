package com.example.timesheet.dto;

import com.example.timesheet.entity.Timesheet;
import jakarta.validation.constraints.NotNull;

public class StatusUpdateRequest {

    @NotNull(message = "Status is required")
    private Timesheet.Status status;

    public Timesheet.Status getStatus() {
        return status;
    }

    public void setStatus(Timesheet.Status status) {
        this.status = status;
    }
}