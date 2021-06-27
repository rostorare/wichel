package htw.berlin.wichteln.controller;

import java.util.List;

import htw.berlin.wichteln.exception.EventNotFoundException;
import htw.berlin.wichteln.jpa.EventRepository;
import htw.berlin.wichteln.model.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
clasxs EventController {

    private final EventRepository repository;
    private Event event;
    private BindingResult result;
    private Model model;

    EventController(EventRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/eventstable")
    public String eventTable(Model m) {
        List<Event> events = (List<Event>) repository.findAll();
        m.addAttribute("events", events);
        return "eventstable";
    }
    // Aggregate root List<Event> all() { (List<Event>) repository.findAll();
    // tag::get-aggregate-root[]

    // end::get-aggregate-root[]
    @GetMapping("/eventcreation")
    public String percre(@ModelAttribute Event p, Model m){
        //repository.save(p);
        m.addAttribute("event",p);
        return "eventcreation";
    }
    @PostMapping("/eventcreation")
    public String perso(@ModelAttribute Event event, Model model){
        repository.save(event);
        return "eventresult";
    }

//    @GetMapping("/eventresult")
    //  public ModelAndView mav() {
    //    ModelAndView mav = new ModelAndView();
    //  mav.setViewName("eventresult.html");
    // return mav;
    //}

    //   @RequestMapping(value="/eventcreation", method={RequestMethod.POST})
    // public Event addEvent(@ModelAttribute(value="event")Event event){
//        return repository.save(event);
    //  }

    // Single item

    @GetMapping("/events/{id}")
    Event one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new EventNotFoundException(id));
    }

    @PutMapping("/events/{id}")
    Event replaceEvent(@RequestBody Event newEvent, @PathVariable Long id) {

        return repository.findById(id)
                .map(event -> {
                    event.setName(newEvent.getName());
                                    return repository.save(event);
                })
                .orElseGet(() -> {
                    return repository.save(newEvent);
                });
    }

    @DeleteMapping("/events/{id}")
    void deleteEvent(@PathVariable Long id) {
        repository.deleteById(id);
    }
}