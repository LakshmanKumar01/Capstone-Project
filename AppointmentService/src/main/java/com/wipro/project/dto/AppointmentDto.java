package com.wipro.project.dto;


import lombok.Data;
import java.time.LocalDateTime;

@Data
public class AppointmentDto {

    private Long patientId;

    private Long doctorId;

    private LocalDateTime appointmentDate;

    private String notes;
}
