package it.formarete.model;

import it.formarete.service.EmployeeDAO;

import com.opensymphony.xwork2.ActionSupport;

public class Employee extends ActionSupport {
	private static final long serialVersionUID = -3637288302808865450L;

	private int id;
	private String name;
	private float salary;
	private EmployeeDAO dao;

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

	public EmployeeDAO getDao() {
		return dao;
	}

	public void setDao(EmployeeDAO dao) {
		this.dao = dao;
	}

	@Override
	public String execute() throws Exception {
		// Resource resource = new ClassPathResource("applicationContext.xml");
		// BeanFactory factory = new XmlBeanFactory(resource);
		// EmployeeDAO dao = (EmployeeDAO) factory.getBean("employee");
		dao.save(this);
		return SUCCESS;
	}
}
