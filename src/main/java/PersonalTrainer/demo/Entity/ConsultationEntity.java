package PersonalTrainer.demo.Entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "consultations")
@Data
public class ConsultationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String goals;
    private String experience;
    private String height;
    private String weight;
    private String age;
    private String gender;
}
