package lk.himash.patient.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {

    private String patient_id;

    private String first_name;

    private String last_name;

    private String age;

    private String marital_status;

    private String state;

    private String disease;

}
