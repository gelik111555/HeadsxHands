package Models;

public class ResultBase {
    private boolean successful; // Успешна ли была операция
    private String message; // Сообщение о результате

    public ResultBase(boolean successful, String message) {
        this.successful = successful;
        this.message = message;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public String getMessage() {
        return message;
    }
}
