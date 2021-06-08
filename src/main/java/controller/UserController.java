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


public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao = request.getParameter("acao");
		String paramId = request.getParameter("id");
		
		System.out.println(paramAcao);
		
		UserService service = new UserService();
		
		if(paramAcao.equals("remover")) {
			User user = service.findOne(paramId);
			
			service.remove(user);
			
			response.sendRedirect("dashBoard");			
		}
		
		if(paramAcao.equals("atualizar")) {
			User user = service.findOne(paramId);
			Telephone telephone = user.getTelefone().get(0);
			Telephone telephone2 = user.getTelefone().get(1);
			
			request.setAttribute("user", user);
			request.setAttribute("telephone", telephone);
			request.setAttribute("telephone2", telephone2);
				
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/FormUpdate.jsp");
			rd.forward(request, response);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService service = new UserService();
		
		User user = new User();
		Telephone telephoneFixo = new Telephone();
		Telephone telephoneCelular = new Telephone();
		
		String email = request.getParameter("email");
		String nome = request.getParameter("nome");
		String password = request.getParameter("password");
		String telefone1 = request.getParameter("telefone1");
		System.out.println(request.getParameter("ddd1"));
		int ddd1 = Integer.parseInt(request.getParameter("ddd1"));
		String tipo1 = request.getParameter("tipo1");
		String telefone2 = request.getParameter("telefone2");
		int ddd2 = Integer.parseInt(request.getParameter("ddd2"));
		String tipo2 = request.getParameter("tipo2");
		
		user.setEmail(email);
		user.setName(nome);
		user.setPassword(password);
		
		User acharId = service.findOne(email);
		
		telephoneFixo.setId(acharId.getTelefone().get(0).getId());
		telephoneFixo.setDdd(ddd1);
		telephoneFixo.setNumber(telefone1);
		telephoneFixo.setType(tipo1);
		
		telephoneCelular.setId(acharId.getTelefone().get(1).getId());
		telephoneCelular.setDdd(ddd2);
		telephoneCelular.setNumber(telefone2);
		telephoneCelular.setType(tipo2);
		
		List<Telephone> teleList = new ArrayList<Telephone>();
		
		teleList.add(telephoneCelular);
		teleList.add(telephoneFixo);
		
		user.setTelefone(teleList);
		
		service.atualizar(user);
		
		response.sendRedirect("dashBoard");
	}
		


}
