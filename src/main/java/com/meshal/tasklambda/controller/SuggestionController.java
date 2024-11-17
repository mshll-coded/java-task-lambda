package com.meshal.tasklambda.controller;


import com.meshal.tasklambda.bo.CreateSuggestionRequest;
import com.meshal.tasklambda.entity.GuestSuggestionEntity;
import com.meshal.tasklambda.service.GuestSuggestionService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class SuggestionController {

    private final GuestSuggestionService guestSuggestionService;

    @PostMapping("/suggestions")
    public ResponseEntity<String> createSuggestion(@RequestBody CreateSuggestionRequest request) {
        try {
            guestSuggestionService.printAndProcessSuggestion(request);
            return ResponseEntity.ok("Suggestion created");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/suggestions")
    public ResponseEntity<List<GuestSuggestionEntity>> getSuggestions() {
        try {
            List<GuestSuggestionEntity> guestSuggestions = guestSuggestionService.getSuggestions();
            return ResponseEntity.ok(guestSuggestions);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
