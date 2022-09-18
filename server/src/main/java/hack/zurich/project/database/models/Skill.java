package hack.zurich.project.database.models;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tbl_skills")
@Data
public class Skill {
    @Id
    @Column(name = "skill_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;
}
