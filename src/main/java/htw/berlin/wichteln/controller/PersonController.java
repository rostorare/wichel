package htw.berlin.wichteln.controller;


import htw.berlin.wichteln.exception.PersonNotFoundException;
import htw.berlin.wichteln.jpa.PersonRepository;
import htw.berlin.wichteln.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin
@RestController
public class PersonController {

    private final PersonRepository repository;
    PersonController(PersonRepository repository){
        this.repository = repository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/person")
    List<Person> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/person")
    Person newPerson(@RequestBody Person newPerson) {
        return repository.save(newPerson);
    }

    // Single item

    @GetMapping("/Persons/{id}")
    Person one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    // mach tnicht viel sinn kein put id???
   @PutMapping("/Persons/{id}")
       Person replacePerson(@RequestBody Person newPerson, @PathVariable Long id) {

        return repository.findById(id)
                .map(Person -> {
                    Person.setName(newPerson.getName());
                    Person.setMail(newPerson.getMail());
                    return repository.save(Person);
                })
                .orElseGet(() -> {
                    newPerson.setId(id);
                    return repository.save(newPerson);
                });
    }

    @DeleteMapping("/Persons/{id}")
    void deletePerson(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
