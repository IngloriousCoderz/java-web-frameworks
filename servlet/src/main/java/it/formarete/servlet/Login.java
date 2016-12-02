package it.formarete.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {

	private static final long serialVersionUID = -8283079335409541319L;

	private final static String RIGHT_USERNAME = "giancarlo";
	private final static String RIGHT_PASSWORD = "magalli";

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (RIGHT_USERNAME.equals(username) && RIGHT_PASSWORD.equals(password)) {
			request.setAttribute("username", username);
			request.getRequestDispatcher("/hello.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/login-error.jsp").forward(request,
							response);
		}
	}
}
