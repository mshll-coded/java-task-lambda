package com.meshal.tasklambda.entity;

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

    public GuestSuggestionEntity(String suggestionText, int rate) {
        this.suggestionText = suggestionText;
        this.rate = rate;
    }
}
