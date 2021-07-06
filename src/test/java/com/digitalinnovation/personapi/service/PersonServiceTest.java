package com.digitalinnovation.personapi.service;

import com.digitalinnovation.personapi.dto.MessageResponseDto;
import com.digitalinnovation.personapi.entity.Person;
import com.digitalinnovation.personapi.repository.PersonRepository;
import com.digitalinnovation.personapi.util.PersonUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    public void givenAPersonReturnMessage(){
        Person person = PersonUtil.toPerson();

        when(personRepository.save(person)).thenReturn(person);

        MessageResponseDto expectSucessMessage = MessageResponseDto.builder()
                .message("Saved person with id " + person.getId())
                .build();
        MessageResponseDto messageResponseDto = personService.createPerson(person);

        assertEquals(expectSucessMessage, messageResponseDto);
    }

}
