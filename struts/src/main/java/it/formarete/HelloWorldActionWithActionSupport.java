package it.formarete;

import com.opensymphony.xwork2.ActionSupport;

public class HelloWorldActionWithActionSupport extends ActionSupport {
	private static final long serialVersionUID = -7083615185862607648L;

	private String name;

	public String execute() throws Exception {
		if ("SECRET".equals(name)) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
