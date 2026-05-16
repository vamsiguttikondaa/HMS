package com.hospitalManagement;

import com.hospitalManagement.entity.Patient;
import com.hospitalManagement.entity.type.BloodGroupType;
import com.hospitalManagement.repository.PatientRepository;
import com.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository() {

        List<Patient> patientList = patientRepository.findAll();
        for(Patient p:patientList){
            System.out.println(p);
        }

    }
    @Test
    public void display(){
//        List<Patient> patientList = patientRepository.findByBirthDateGreaterThan(LocalDate.of(1990,01,01));
//
//        for(Patient patient: patientList) {
//            System.out.println(patient);
//        }
//        List<Object[]> pc=patientRepository.countEachBloodGroupType();
//        for(Object[] p:pc){
//            System.out.println(p[0]+"    "+p[1]);
//        }
        int res=patientRepository.updatePatientName("vamsi",1l);
        System.out.println(res);
        testPatientRepository();
    }
    @Test
    public void testTransactionMethods() {
//        Patient patient = patientService.getPatientById(1L);

//        Patient patient = patientRepository.findById(1L).orElseThrow(() -> new EntityNotFoundException("Patient not " +
//                "found with id: 1"));

//        Patient patient = patientRepository.findByName("Diya Patel");

//        List<Patient> patientList = patientRepository.findByBirthDateOrEmail(LocalDate.of(1988, 3, 15), "diya" +
//                ".patel@example.com");

//        List<Patient> patientList = patientRepository.findByBornAfterDate(LocalDate.of(1993, 3, 14));

//
//        List<Object[]> bloodGroupList = patientRepository.countEachBloodGroupType();
//        for(Object[] objects: bloodGroupList) {
//            System.out.println(objects[0] +" "+ objects[1]);
//        }

//        int rowsUpdated = patientRepository.updateNameWithId("Arav Sharma", 1L);
//        System.out.println(rowsUpdated);

//        List<BloodGroupCountResponseEntity> bloodGroupList = patientRepository.countEachBloodGroupType();
//        for(BloodGroupCountResponseEntity bloodGroupCountResponse: bloodGroupList) {
//            System.out.println(bloodGroupCountResponse);
//        }
    }
}
























