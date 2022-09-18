package hack.zurich.project.database.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tbl_questions")
@Data
public class Question implements Serializable {

    @Id
    @Column(name = "question_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "description")
    private String description;

    @Column(name = "skill_id")
    private Integer skillId;

    @Column(name = "presenting_answers_option")
    private Integer type;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;
}
