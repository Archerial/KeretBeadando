package uni.eszterhazy.beadando.exceptions;

public class InvalidParams extends Throwable{
    public InvalidParams(String param) {
        super(param);
    }
}
