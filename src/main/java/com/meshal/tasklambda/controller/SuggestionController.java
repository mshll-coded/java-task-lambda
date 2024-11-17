package com.meshal.tasklambda.controller;


import com.meshal.tasklambda.bo.CreateSuggestionRequest;
import com.meshal.tasklambda.bo.SuggestionResponse;
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
    public ResponseEntity<SuggestionResponse> createSuggestion(@RequestBody CreateSuggestionRequest request) {
        try {
            guestSuggestionService.printAndProcessSuggestion(request);
            return ResponseEntity.ok(new SuggestionResponse("Suggestion created successfully", request));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new SuggestionResponse(e.getMessage(), null));
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

    @GetMapping("/suggestions/create")
    public ResponseEntity<List<GuestSuggestionEntity>> getCreatedSuggestions() {
        try {
            return ResponseEntity.ok(guestSuggestionService.findAllCreatedSuggestions());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/suggestions/remove")
    public ResponseEntity<List<GuestSuggestionEntity>> getRemovedSuggestions() {
        try {
            return ResponseEntity.ok(guestSuggestionService.findAllRemovedSuggestions());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
