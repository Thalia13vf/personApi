package com.digitalinnovation.personapi.service;

import com.digitalinnovation.personapi.dto.MessageResponseDto;
import com.digitalinnovation.personapi.entity.Person;
import com.digitalinnovation.personapi.exception.PersonNotFoundException;
import com.digitalinnovation.personapi.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {
    private final PersonRepository personRepository;

    public MessageResponseDto createPerson(Person person) {

        Person savedPerson = personRepository.save(person);

        return createMessageResponseDto(savedPerson.getId(), "Saved person with id ");
    }

    public List<Person> listAll() {
        return personRepository.findAll();
    }

    public Person findById(Long id) throws PersonNotFoundException {
        return verifyIfExists(id);
    }

    public void deleteById(Long id) throws PersonNotFoundException {
        verifyIfExists(id);
        personRepository.deleteById(id);
    }

    public MessageResponseDto updateById(Long id, Person person) throws PersonNotFoundException {
        verifyIfExists(id);
        person.setId(id);

        personRepository.save(person);
        return createMessageResponseDto(person.getId(), "Updated person with id ");
    }

    private MessageResponseDto createMessageResponseDto(Long id, String message) {
        return MessageResponseDto.builder()
                .message(message + id)
                .build();
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

}
