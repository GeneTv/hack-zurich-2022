package hack.zurich.project.database.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "organisations")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Organisation {
    @Id
    @Column(name = "organisation_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "programs")
    private String programs;
}
