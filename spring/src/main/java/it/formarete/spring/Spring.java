package it.formarete.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring {

	private double k;

	public double getK() {
		return k;
	}

	public void setK(double k) {
		this.k = k;
	}

	public double getForce(double x) {
		return k * x;
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Spring spring = (Spring) context.getBean("spring");
		System.out.println(spring.getForce(10));
	}
}
