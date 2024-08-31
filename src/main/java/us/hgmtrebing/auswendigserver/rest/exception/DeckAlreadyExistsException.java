package us.hgmtrebing.auswendigserver.rest.exception;

import java.util.UUID;

public class DeckAlreadyExistsException extends RuntimeException {
  public DeckAlreadyExistsException(UUID identifier) {
    super("A deck with the identifier " + identifier + " already exists!");
  }
}
