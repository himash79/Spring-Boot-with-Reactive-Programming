package lk.himash.doctor.repository;

import lk.himash.doctor.model.Doctor;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends MongoRepository<Doctor,String>{

    @Query("{ marital_status : ?0 }")
    public List<Doctor> getDoctorRelatedMaritalStatus(String mStatus);

}
