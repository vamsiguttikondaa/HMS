package com.hospitalManagement;

import com.hospitalManagement.entity.Insurance;
import com.hospitalManagement.entity.Patient;
import com.hospitalManagement.repository.InsuranceRepository;
import com.hospitalManagement.repository.PatientRepository;
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
}
