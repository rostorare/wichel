package htw.berlin.wichteln.jpa;

import htw.berlin.wichteln.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.List;

// find people by id,name or mail...
@RepositoryRestResource
public interface PersonRepository extends JpaRepository <Person,Long>{
    List<Person> findByName(String name);
    Person findById(long id);
    Person findByMail(String mail);

    //Now we can use JpaRepository’s methods: save(), findOne(), findById(), findAll(), count(), delete(), deleteById()…
    // without implementing these methods.

}
