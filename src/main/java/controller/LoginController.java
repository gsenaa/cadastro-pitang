package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.UserService;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("login");
		String senha = request.getParameter("password");
		
		UserService service = new UserService();
		
		User userExists = service.findOne(email);

		
		
		if(userExists == null) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/Login.jsp");
			rd.forward(request, response);
	    }
		
		if(userExists != null) {
			if(senha.equals(userExists.getPassword())) {
				System.out.println("asdjuiasdsahduyi");
				response.sendRedirect("dashBoard");
			}
	    }else {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/Login.jsp");
			rd.forward(request, response);
		}
		

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	

}
