package lk.ijse.hostel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentDTO {
    @Id
    private String studentId;
    private String StudentName;
    private String address;
    private int contact_number;
    private String date_of_birth;
    private String gender;
}
