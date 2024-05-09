package hello.jdbc.respository.ex;

public class MyDuplicationKeyException extends MyDBException{
    public MyDuplicationKeyException() {
        super();
    }

    public MyDuplicationKeyException(String message) {
        super(message);
    }

    public MyDuplicationKeyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyDuplicationKeyException(Throwable cause) {
        super(cause);
    }
}
