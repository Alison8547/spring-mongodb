package com.br.springmongodb.service;

import com.br.springmongodb.domain.Responsible;
import com.br.springmongodb.exception.BusinessException;
import com.br.springmongodb.repository.ResponsibleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Log4j2
@Service
@RequiredArgsConstructor
public class ResponsibleService {

    private final ResponsibleRepository responsibleRepository;


    public void createResponsible(Responsible responsible) {
        if (responsible.getAge() < 18){
            throw new BusinessException("The person responsible must be of legal age");
        }
        responsible.setCreated(LocalDateTime.now());
        responsibleRepository.insert(responsible);
        log.info("Responsible created: {}", responsible);
    }
}
