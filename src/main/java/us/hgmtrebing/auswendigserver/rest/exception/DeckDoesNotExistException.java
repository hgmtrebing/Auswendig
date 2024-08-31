package us.hgmtrebing.auswendigserver.rest.exception;

import java.util.UUID;

public class DeckDoesNotExistException extends RuntimeException {
    public DeckDoesNotExistException(UUID identifier) {
        super("A deck with the external identifier " + identifier + " does not exist!");
    }
}
