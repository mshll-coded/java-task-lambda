package com.meshal.tasklambda.controller;


import com.meshal.tasklambda.bo.CreateSuggestionRequest;
import com.meshal.tasklambda.service.GuestSuggestionService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SuggestionController {

    private final GuestSuggestionService guestSuggestionService;

    @PostMapping("/api/suggestions")
    public ResponseEntity<String> createSuggestion(@RequestBody CreateSuggestionRequest request) {
        guestSuggestionService.printAndProcessSuggestion(request);
        return ResponseEntity.ok("Suggestion created");
    }
}
