package com.criCoinController;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.criCoinWeb.*;

/**
 * Servlet implementation class CriCoinController
 */
@WebServlet("/pepe")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO modeloUser;
	private WalletDAO modeloWallet;
	private CoinDAO modeloCoin;
	private HttpSession session;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserController() {
		super();
		modeloUser = new UserDAO();
		modeloWallet = new WalletDAO();
		modeloCoin = new CoinDAO();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String accion = request.getParameter("accion");
		System.out.println(accion);
		session = request.getSession(true);

		if (accion == null) {
			accion = "";
		}
		if (accion.equals("nuevo")) {
			// Pondré el código para mostrar la página para introducir los nuevos datos
			String pass = request.getParameter("pass");
			String pass1 = request.getParameter("pass1");
			String email = (request.getParameter("email"));

//			System.out.println(pass);
//			System.out.println(pass1);
//			System.out.println(email);
//			
			if (pass.equals("") || pass == null || pass1.equals("") || pass1 == null || email.equals("")
					|| email == null) {

				request.setAttribute("mensaje", "Debes rellenar todos los campos");
				request.setAttribute("email", email);
				RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
				dispatcher.forward(request, response);

			} else if (!pass.equals(pass1)) {

				request.setAttribute("mensaje", "La contraseña no coincide");
				RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
				dispatcher.forward(request, response);

			}

			UserPojo usuario = new UserPojo(0, email, pass);
			modeloUser.addUser(usuario);
			request.setAttribute("email", email);
			request.setAttribute("pass", pass);
			RequestDispatcher dispatcher = request.getRequestDispatcher("editarPrueba.jsp");
			dispatcher.forward(request, response);

		} else if (accion.equals("insertar")) {
			// Aquí recuperaré los datos y los añadiré a la base de datos
			System.out.println("Hola, preparado para insertar");

			String nick = request.getParameter("nick");
			String first_name = request.getParameter("first_name");
			String last_name = request.getParameter("last_name");
			Date b_date = Date.valueOf(request.getParameter("b_date"));
			String country = request.getParameter("country");
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");

			UserPojo usuario = new UserPojo(0, nick, first_name, last_name, b_date, country, email, pass);
			modeloUser.updateUser(usuario, modeloUser.getUserIdByEmail(email));

		} else if (accion.equals("borrar")) {
			// Recupero el id y elimino el registro

		} else if (accion.equals("editar")) {
			// Recuperaré el registro que tenga el id que me pasan y
			// Mandaré los datos a una página para que el usuario los modifique

		} else if (accion.equals("modificar")) {
			// Recupero los datos que me pasan y modifico el registro en la base de datos

		} else {

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
