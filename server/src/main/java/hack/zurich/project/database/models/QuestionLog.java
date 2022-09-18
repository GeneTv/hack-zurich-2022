package hack.zurich.project.database.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "question_log")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionLog {
    //TODO: add models for log here

    @Id
    private String id = UUID.randomUUID().toString();

    private int questionId;
    private String answer;
    private LocalDateTime timestamp;
}
