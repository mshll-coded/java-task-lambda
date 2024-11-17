package com.meshal.tasklambda.service;

import com.meshal.tasklambda.bo.CreateSuggestionRequest;
import com.meshal.tasklambda.bo.SuggestionResponse;
import com.meshal.tasklambda.entity.GuestSuggestionEntity;
import com.meshal.tasklambda.repository.GuestSuggestionRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Getter
@Setter
@Service
public class GuestSuggestionService {

    @Autowired
    private GuestSuggestionRepository guestSuggestionRepository;

    public GuestSuggestionService(GuestSuggestionRepository guestSuggestionRepository) {
        this.guestSuggestionRepository = guestSuggestionRepository;
    }

    final SuggestionProcessor processSuggestion = ((text) -> {
        GuestSuggestionEntity suggestion = new GuestSuggestionEntity(1, text);
        guestSuggestionRepository.save(suggestion);
    });

    public void printAndProcessSuggestion(CreateSuggestionRequest request) {
        processSuggestion.process(request.getText());
        System.out.println(request.getText());
    }

    public List<GuestSuggestionEntity> getSuggestions() {
        return guestSuggestionRepository.findAll();
    }
}
