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

public class CadastroController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = new User();
		Telephone telephoneFixo = new Telephone();
		Telephone telephoneCelular = new Telephone();
		
		String email = request.getParameter("email");
		String nome = request.getParameter("nome");
		String password = request.getParameter("password");
		String telefone1 = request.getParameter("telefone1");
		int ddd1 = Integer.parseInt(request.getParameter("ddd1"));
		String tipo1 = request.getParameter("tipo1");
		String telefone2 = request.getParameter("telefone2");
		int ddd2 = Integer.parseInt(request.getParameter("ddd2"));
		String tipo2 = request.getParameter("tipo2");
		
		user.setEmail(email);
		user.setName(nome);
		user.setPassword(password);
		
		telephoneFixo.setDdd(ddd1);
		telephoneFixo.setNumber(telefone1);
		telephoneFixo.setType(tipo1);
		
		telephoneCelular.setDdd(ddd2);
		telephoneCelular.setNumber(telefone2);
		telephoneCelular.setType(tipo2);
		
		List<Telephone> teleList = new ArrayList<Telephone>();
		
		teleList.add(telephoneCelular);
		teleList.add(telephoneFixo);
		
		user.setTelefone(teleList);
		
		UserService userService = new UserService();
		
		userService.create(user);
		
		response.sendRedirect("/cadastropitang/dashBoard");
			
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/Cadastro.jsp");
		rd.forward(request, response);
		
	}

}
