package it.formarete.action;

import it.formarete.model.IUser;

import com.opensymphony.xwork2.Action;

public class Login implements Action {

    private String username;
    private IUser user;
    private String message;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public IUser getUser() {
        return user;
    }

    public void setUser(IUser user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

		@Override
    public String execute() {
        user.setName(username);
        return SUCCESS;
    }
}
