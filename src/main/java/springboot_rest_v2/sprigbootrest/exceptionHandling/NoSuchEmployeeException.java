package springboot_rest_v2.sprigbootrest.exceptionHandling;

public class NoSuchEmployeeException extends RuntimeException {

    public NoSuchEmployeeException(String message){
        super(message);
    }
}
