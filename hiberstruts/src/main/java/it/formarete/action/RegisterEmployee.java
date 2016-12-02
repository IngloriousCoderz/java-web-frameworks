package it.formarete.action;

import it.formarete.model.Employee;
import it.formarete.service.EmployeeDAO;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterEmployee extends ActionSupport {

	private static final long serialVersionUID = -4464670203762168320L;

	private String name;
	private float salary;
	private List<Employee> employees;

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

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String execute() throws Exception {
		EmployeeDAO dao = new EmployeeDAO();

		Employee employee = new Employee();
		employee.setName(name);
		employee.setSalary(salary);
		dao.save(employee);

		employees = dao.getAll();

		return SUCCESS;
	}
}
