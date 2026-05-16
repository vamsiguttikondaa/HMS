package com.hospitalManagement.service;

import com.hospitalManagement.entity.Appointment;
import com.hospitalManagement.entity.Doctor;
import com.hospitalManagement.entity.Patient;
import com.hospitalManagement.repository.AppointmentRepository;
import com.hospitalManagement.repository.DoctorRepository;
import com.hospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
        private final DoctorRepository doctorRepository;
        private final PatientRepository patientRepository;
        private final AppointmentRepository appointmentRepository;

        @Transactional
        public Appointment createNewAppointment(Appointment appointment,Long doctorId,Long patientId){
            Patient patient=patientRepository.findById(patientId).orElseThrow(()->new EntityNotFoundException("patient not found with ID:"+patientId));
            Doctor doctor=doctorRepository.findById(doctorId).orElseThrow(()->new EntityNotFoundException("doctor not found with ID:"+doctorId));
            if(appointment.getId()!=null){
                throw new IllegalArgumentException("appointment should not have ID");
            }
            appointment.setDoctor(doctor);
            appointment.setPatient(patient);

            patient.getAppointments().add(appointment); //BI
            return appointmentRepository.save(appointment);

        }
    @Transactional
    public Appointment reAssignAppointmentToAnotherDoctor(Long appointmentId, Long doctorId) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor); // this will automatically call the update, because it is dirty

        doctor.getAppointments().add(appointment); // just for bidirectional consistency

        return appointment;
    }
}
