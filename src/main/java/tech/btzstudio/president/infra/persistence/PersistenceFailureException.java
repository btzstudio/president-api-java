package tech.btzstudio.president.infra.persistence;

public class PersistenceFailureException extends Exception {

    public PersistenceFailureException (String message, Throwable cause) {
        super(message, cause);
    }
}
