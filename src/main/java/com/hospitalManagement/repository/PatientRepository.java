package com.hospitalManagement.repository;

import com.hospitalManagement.dto.BloodGroupCountResponseEntity;
import com.hospitalManagement.entity.Patient;
import com.hospitalManagement.entity.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.List;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByName(String name);
    @Query("SELECT p FROM Patient p where p.bloodGroup=?1")
    List<Patient> findByBloodGroupType(@Param("bloodGroup")BloodGroupType bloodGroup);

    List<Patient> findByBirthDateGreaterThan(LocalDate date);
    @Query("SELECT p.bloodGroup,Count(p) FROM Patient p group by p.bloodGroup")
    List<BloodGroupCountResponseEntity> countEachBloodGroupType();
   @Transactional
    @Modifying
    @Query("UPDATE Patient p  SET p.name=?1 where p.id=?2")
    int updatePatientName(@Param("name") String name,@Param("id") Long id);

    @Query(value = "select * from patient", nativeQuery = true)
    Page<Patient> findAllPatients(Pageable pageable);
}
