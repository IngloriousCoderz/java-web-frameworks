package it.formarete.action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport implements SessionAware {

    private static final long serialVersionUID = 7707616616073833631L;

    private String name;
    private String password;
    private SessionMap<String, Object> session;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, Object> getSession() {
        return session;
    }
    
    @Override
    public void setSession(Map<String, Object> session) {
        this.session = (SessionMap<String, Object>) session;
    }

    @Override
    public String execute() {
        if (session.get("login") == "true") {
            return SUCCESS;
        }
        
        if ("admin".equals(name) && "admin".equals(password)) {
            session.put("login", "true");
            session.put("name", name);
            return SUCCESS;
        }
        
        return LOGIN;
    }

    public String logout() {
        if (session != null) {
            session.invalidate();
        }
        return SUCCESS;
    }
}
