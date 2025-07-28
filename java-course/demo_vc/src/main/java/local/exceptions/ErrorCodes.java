package local.exceptions;

public enum ErrorCodes {
    ERROR_BIGGER_20("No se admiten números mayores que 20"), 
    ERROR_NEGATIVE("No se admiten números negativos"),
    ERROR_ZERO("No se puedo dividir por cero");

    String message;

    ErrorCodes(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
