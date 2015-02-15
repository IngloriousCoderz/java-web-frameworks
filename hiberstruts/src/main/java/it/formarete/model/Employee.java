package it.formarete.model;

import it.formarete.service.EmployeeDAO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.opensymphony.xwork2.ActionSupport;

@Entity
@Table(name = "employee")
public class Employee extends ActionSupport {
	private static final long serialVersionUID = -3637288302808865450L;

	@Id
	private int id;
	private String name;
	private float salary;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	@Override
	public String execute() throws Exception {
		new EmployeeDAO().save(this);
		return SUCCESS;
	}
}
