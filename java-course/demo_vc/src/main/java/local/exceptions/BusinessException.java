package local.exceptions;

// Checked Exception

public class BusinessException extends Exception {

    private static String generateMessage(ErrorCodes code, String message) {
        return code + " - " + message;
    }
    
    ErrorCodes code;

    public BusinessException(ErrorCodes code, String message) {
        super(generateMessage(code, message));
        this.code = code;
    }

    public BusinessException(ErrorCodes code, String message, Throwable cause) {
        super(generateMessage(code, message), cause);
        this.code = code;
    }
}




