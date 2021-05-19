package com.github.lessalc.personapi.service;

import com.github.lessalc.personapi.dto.response.MessageResponseDTO;
import com.github.lessalc.personapi.entity.Person;
import com.github.lessalc.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(Person person){
        Person savedPerson = personRepository.saveAndFlush(person);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID "+savedPerson.getId())
                .build();
    }


}
