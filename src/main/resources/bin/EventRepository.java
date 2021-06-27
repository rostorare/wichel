package htw.berlin.wichteln.jpa;

import htw.berlin.wichteln.model.Event;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public intxerface EventRepository extends CrudRepository<Event, Long> {
    //Event findById(Long id);
    //Event findByName(String name);
}
