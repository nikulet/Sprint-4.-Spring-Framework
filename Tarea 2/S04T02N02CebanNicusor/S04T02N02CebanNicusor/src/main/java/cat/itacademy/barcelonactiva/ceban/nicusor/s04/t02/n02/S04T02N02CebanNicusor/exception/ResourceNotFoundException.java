package cat.itacademy.barcelonactiva.ceban.nicusor.s04.t02.n02.S04T02N02CebanNicusor.exception;

public class ResourceNotFoundException extends RuntimeException{
    private static final long seralVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
