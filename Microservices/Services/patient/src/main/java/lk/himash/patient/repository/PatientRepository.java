package lk.himash.patient.repository;

import lk.himash.patient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {

    @Query("select p from Patient p order by first_name ASC")
    List<Patient> getPatientByNameASC();

    @Query("select p from Patient p order by first_name DESC")
    List<Patient> getPatientByNameDESC();

    @Query("select p from Patient p order by age ASC")
    List<Patient> getPatientByAgeASC();

    @Query("select p from Patient p order by age DESC")
    List<Patient> getPatientByAgeDESC();
}
