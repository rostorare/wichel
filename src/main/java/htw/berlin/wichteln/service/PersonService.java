package htw.berlin.wichteln.service;


import htw.berlin.wichteln.jpa.PersonRepository;
import htw.berlin.wichteln.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;



    public List<Person> findAlle() {
        var iterator = personRepository.findAll();
        var persons = new ArrayList<Person>();
        for (Person p : iterator) {
            if(p.getId()!=null && p.getName()!=null & p.getMail()!=null) persons.add(p);
        }
        return persons;
    }

    public Long count() {
        return personRepository.count();
    }

    public void deleteById(Long personId) {

        personRepository.deleteById(personId);
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }


}
