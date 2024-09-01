package us.hgmtrebing.auswendigserver.rest.exception;

import java.util.UUID;

public class CardAlreadyExistsException extends RuntimeException{

    public CardAlreadyExistsException(UUID identifier) {
        super("A card with the identifier " + identifier + " already exists!");
    }
}
