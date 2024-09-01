package us.hgmtrebing.auswendigserver.rest.exception;

import java.util.UUID;

public class CardDoesNotExistException extends RuntimeException {

  public CardDoesNotExistException(UUID identifier) {
    super("A card with the external identifier " + identifier + " does not exist!");
  }
}
