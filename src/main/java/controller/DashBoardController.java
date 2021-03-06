package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Telephone;
import model.User;
import service.UserService;


/**
 * Servlet implementation class DashBoardController
 */
public class DashBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserService service = new UserService();
			
		List<User> user =  service.findAll();
		List<Telephone> telefone = new ArrayList<Telephone>();
		

		for (int i = 0; i < user.size(); i++) {
			for (int j = 0; j < 2; j++) {
				Telephone tel = user.get(i).getTelefone().get(j);
				telefone.add(tel);
			}
		}
		
		request.setAttribute("telephones", telefone);
		
		request.setAttribute("users", user);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/DashBoard.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
