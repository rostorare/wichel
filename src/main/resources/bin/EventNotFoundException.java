package htw.berlin.wichteln.exception;

public claxss EventNotFoundException extends RuntimeException{
    public EventNotFoundException(Long id) {
        super("Could not find event " + id);
    }
}
