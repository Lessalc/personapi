package com.github.lessalc.personapi.service;


import com.github.lessalc.personapi.dto.request.PersonDTO;
import com.github.lessalc.personapi.dto.response.MessageResponseDTO;
import com.github.lessalc.personapi.entity.Person;
import com.github.lessalc.personapi.repository.PersonRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.github.lessalc.personapi.utils.PersonUtils.createFakeDTO;
import static com.github.lessalc.personapi.utils.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {

        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MessageResponseDTO expectedSuccessMessage = createdExpectedMessageResponse(expectedSavedPerson);

        MessageResponseDTO sucessMessage = personService.createPerson(personDTO);

        assertEquals(expectedSuccessMessage, sucessMessage);
    }

    private MessageResponseDTO createdExpectedMessageResponse(Person expectedSavedPerson) {
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + expectedSavedPerson.getId())
                .build();
    }
}
