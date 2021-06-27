package htw.berlin.wichteln.controller;

import java.util.List;

import htw.berlin.wichteln.exception.PersonNotFoundException;

import htw.berlin.wichteln.jpa.PersonRepository;
import htw.berlin.wichteln.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
class PersonController {

    private final PersonRepository repository;
    private Person person;
    private BindingResult result;
    private Model model;

    PersonController(PersonRepository repository) {
        this.repository = repository;
        }

    @GetMapping("/personstable")
    public String personTable(Model m) {
        List<Person> persons = (List<Person>) repository.findAll();
        m.addAttribute("persons", persons);
        return "personstable";
    }
    // Aggregate root List<Person> all() { (List<Person>) repository.findAll();
    // tag::get-aggregate-root[]

    // end::get-aggregate-root[]
    @GetMapping("/personcreation")
    public String percre(@ModelAttribute Person p, Model m){
        m.addAttribute("person",p);
        return "personcreation";
    }

    @GetMapping("/dynamiccreation")
    public String dynamicForm(Model model) {
        model.addAttribute("person", new Person());
        return "dynamiccreation";
    }



    @PostMapping("/personcreation")
    public String perso(@ModelAttribute Person person, Model model){
        repository.save(person);
        return "personresult";
    }

//    @GetMapping("/personresult")
  //  public ModelAndView mav() {
    //    ModelAndView mav = new ModelAndView();
      //  mav.setViewName("personresult.html");
       // return mav;
    //}

 //   @RequestMapping(value="/personcreation", method={RequestMethod.POST})
   // public Person addPerson(@ModelAttribute(value="person")Person person){
//        return repository.save(person);
  //  }

    // Single item

    @GetMapping("/persons/{id}")
    Person one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

    @PutMapping("/persons/{id}")
    Person replacePerson(@RequestBody Person newPerson, @PathVariable Long id) {

        return repository.findById(id)
                .map(person -> {
                    person.setName(newPerson.getName());
                    person.setMail(newPerson.getMail());
                    return repository.save(person);
                })
                .orElseGet(() -> {
                        return repository.save(newPerson);
                });
    }

    @DeleteMapping("/persons/{id}")
    void deletePerson(@PathVariable Long id) {
        repository.deleteById(id);
    }
}