package hack.zurich.project.database.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "programs")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Program {

    @Id
    @Column(name = "program_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "required_age")
    private String required_age; //XX-YY (18-25)

    @Column(name = "required_skills")
    private String required_skills;

}
