package htw.berlin.wichteln.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import java.util.List;

// find people by id,name or mail...
@RepositoryRestResource
public interface PersonRepository extends CrudRepository <Person,Long>{
    List<Person> findByName(String name);
    Person findById(long id);
    Person findByMail(String mail);

}
