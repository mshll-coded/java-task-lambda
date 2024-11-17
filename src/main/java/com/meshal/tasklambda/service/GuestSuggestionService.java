package com.meshal.tasklambda.service;

import com.meshal.tasklambda.bo.CreateSuggestionRequest;
import com.meshal.tasklambda.entity.GuestSuggestionEntity;
import com.meshal.tasklambda.functional.SuggestionProcessor;
import com.meshal.tasklambda.repository.GuestSuggestionRepository;
import lombok.Getter;
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

    final SuggestionProcessor processSuggestion = ((text, rate) -> {
        GuestSuggestionEntity suggestion = new GuestSuggestionEntity(text, rate);
        guestSuggestionRepository.save(suggestion);
    });

    public void printAndProcessSuggestion(CreateSuggestionRequest request) {
        processSuggestion.process(request.getText(), request.getRate());
        System.out.println(request.getText());
    }

    public List<GuestSuggestionEntity> getSuggestions() {
        return guestSuggestionRepository.findAll();
    }
}
