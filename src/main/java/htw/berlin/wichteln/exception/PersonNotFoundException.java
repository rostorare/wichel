package htw.berlin.wichteln.exception;

public class PersonNotFoundException extends RuntimeException {

        public PersonNotFoundException(Long id) {
            super("Could not find employee " + id);
        }
    }



