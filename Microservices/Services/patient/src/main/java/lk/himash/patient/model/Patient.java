package lk.himash.patient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "patient")
@Entity
public class Patient {

    @Id
    private String patient_id;

    private String first_name;

    private String last_name;

    private String age;

    private String marital_status;

    private String state;

    private String disease;
}
