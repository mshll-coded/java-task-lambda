package com.meshal.tasklambda.entity;

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

    private int rate;
    private String suggestionText;

    public GuestSuggestionEntity(int rate, String suggestionText) {
        this.rate = rate;
        this.suggestionText = suggestionText;
    }
}
