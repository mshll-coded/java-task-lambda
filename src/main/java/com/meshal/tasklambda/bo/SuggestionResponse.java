package com.meshal.tasklambda.bo;

import com.meshal.tasklambda.entity.GuestSuggestionEntity;
import lombok.*;

@AllArgsConstructor
@Getter
public class SuggestionResponse {
    private String message;
    private CreateSuggestionRequest suggestion;
}
