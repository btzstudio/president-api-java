package tech.btzstudio.president.infra.persistence;

public class PersistenceDuplicatedException extends Exception {

    public PersistenceDuplicatedException (String message) {
        super(message);
    }
}
