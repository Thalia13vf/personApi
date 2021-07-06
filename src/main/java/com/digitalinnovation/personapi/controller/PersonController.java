package com.digitalinnovation.personapi.controller;

import com.digitalinnovation.personapi.dto.MessageResponseDto;
import com.digitalinnovation.personapi.entity.Person;
import com.digitalinnovation.personapi.exception.PersonNotFoundException;
import com.digitalinnovation.personapi.service.PersonService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Salva um objeto")
    public MessageResponseDto createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @GetMapping
    @ApiOperation("Lista de pessoas")
    public List<Person> listAll(){
        return personService.listAll();
    }

    @GetMapping("/{id}")
    @ApiOperation("Lista uma pessoa por id")
    public Person findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Exclui uma pessoa por id")
    public void deleteById(@PathVariable  Long id) throws PersonNotFoundException {
        personService.deleteById(id);
    }

    @PutMapping("/{id}")
    @ApiOperation("Altera uma pessoa por id")
    public MessageResponseDto updateById(@PathVariable Long id, @RequestBody @Valid Person person) throws PersonNotFoundException {
        return personService.updateById(id, person);
    }
}
