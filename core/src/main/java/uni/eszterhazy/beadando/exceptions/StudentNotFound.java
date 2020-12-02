package uni.eszterhazy.beadando.exceptions;

public class StudentNotFound extends Throwable{
    public StudentNotFound(String id) {
        super(id);
    }
}
