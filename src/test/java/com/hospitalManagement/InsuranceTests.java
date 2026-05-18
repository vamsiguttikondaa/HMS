package com.hospitalManagement;

import com.hospitalManagement.entity.Appointment;
import com.hospitalManagement.entity.Insurance;
import com.hospitalManagement.entity.Patient;
import com.hospitalManagement.repository.InsuranceRepository;
import com.hospitalManagement.repository.PatientRepository;
import com.hospitalManagement.service.AppointmentService;
import com.hospitalManagement.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTests {
    @Autowired
    private InsuranceRepository insuranceRepository;
    @Autowired
    private InsuranceService insuranceService;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void TestAssignInsuranceToPatient(){
        Insurance insurance=Insurance.builder()
                .provider("Acko")
                .createdAt(LocalDate.of(2025,8,26))
                .validUntil(LocalDate.of(2026,07,21))
                .policyNumber("acko_12345")
                .build();
        Patient patient=insuranceService.assignInsuranceToPatient(insurance,1l);
        System.out.println(patient);
    }
//    @Test
//    public void testCreateAppointment() {
//        Appointment appointment = Appointment.builder()
//                .appointmentTime(LocalDateTime.of(2025, 11, 1, 14, 0, 0))
//                .reason("Cancer")
//                .build();
//
//        var newAppointment = appointmentService.createNewAppointment(appointment, 1L, 2L);
//
//        System.out.println(newAppointment);
//
//        var updatedAppointment = appointmentService.reAssignAppointmentToAnotherDoctor(newAppointment.getId(), 3L);
//
//        System.out.println(updatedAppointment);
//    }
}
