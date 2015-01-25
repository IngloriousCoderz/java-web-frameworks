package it.formarete;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GoToHelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GoToHelloServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		request.setAttribute("name", name.toUpperCase());
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("hello.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
}
