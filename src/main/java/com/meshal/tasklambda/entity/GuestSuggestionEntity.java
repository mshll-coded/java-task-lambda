package com.meshal.tasklambda.entity;

import com.meshal.tasklambda.enums.SuggestionStatus;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class GuestSuggestionEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String suggestionText;
    private int rate;

    @Enumerated
    private SuggestionStatus status;

    public GuestSuggestionEntity(String suggestionText, int rate, String status) {
        this.suggestionText = suggestionText;
        this.rate = rate;
        this.status = (status == null) ? SuggestionStatus.CREATE : SuggestionStatus.valueOf(status.toUpperCase());
    }
}
