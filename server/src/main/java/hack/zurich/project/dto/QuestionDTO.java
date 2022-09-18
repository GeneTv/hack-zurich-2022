package hack.zurich.project.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuestionDTO {
    private int questionID;
    private String answer;
    private int userId;
    private boolean isOnboarding;
}
