package com.meshal.tasklambda.bo;

import lombok.*;

@RequiredArgsConstructor
@Getter
public class SuggestionResponse {
    private String text;
    private int rate;
}
