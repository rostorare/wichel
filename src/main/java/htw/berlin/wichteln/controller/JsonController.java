package htw.berlin.wichteln.controller;

import htw.berlin.wichteln.model.Person;
import htw.berlin.wichteln.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class JsonController {



    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    public List<Person> allPersons() {
        return personService.findAlle();
    }

    @PostMapping("/persons")
    public Person createPerson(@RequestBody Person person) {
         return personService.save(person);
    }

 //   @DeleteMapping("/persons/{id}")
   // public void delete(@PathVariable String id) {
     //   Long personId = Long.parseLong(id);
       // personService.deleteById(personId);
    //}

    //@GetMapping("/persons/count")
   // public Long count() {        return personService.count();    }

}
