package us.hgmtrebing.auswendigserver.rest.exception;

public class FailedToFindUserException extends AuswendigException {
    private String username;

    public FailedToFindUserException(String username) {
        super();
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
