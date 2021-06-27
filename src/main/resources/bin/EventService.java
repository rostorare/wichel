package htw.berlin.wichteln.service;

import htw.berlin.wichteln.jpa.EventRepository;
import htw.berlin.wichteln.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public clasxs EventService {


    @Autowired
    private EventRepository eventRepository;

    //Event findByName(String name); evtl public method from modle

        public List<Event> findAll(String userEmail) {

        var iterator = eventRepository.findAll();

        var events = new ArrayList<Event>();
        for (Event e : iterator) {
            if(e.getId()!=null && e.getName()!=null ) events.add(e);
        }

        return events;
    }

    public Long count() {

        return eventRepository.count();
    }

    public void deleteById(Long eventId) {

        eventRepository.deleteById(eventId);
    }

    public Event save(Event event) {
        return eventRepository.save(event);
    }















}
