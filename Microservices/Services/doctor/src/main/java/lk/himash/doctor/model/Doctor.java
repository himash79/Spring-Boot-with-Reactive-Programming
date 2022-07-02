package lk.himash.doctor.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Doctor")
public class Doctor {

    @Id
    private String _id;
    private String first_name;
    private String last_name;
    private String age;
    private String marital_status;
    private String state;

}
