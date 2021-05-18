package com.criCoinController;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

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
@WebServlet("/controller")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO modeloUser;
	private WalletDAO modeloWallet;
	private CoinDAO modeloCoin;
	private HttpSession session;
	private ConexionAPI conexionApi;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserController() {
		super();
		modeloUser = new UserDAO();
		modeloWallet = new WalletDAO();
		modeloCoin = new CoinDAO();		
		conexionApi = new ConexionAPI();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String accion = request.getParameter("accion");

		if (accion.equals("nuevo")) {
			String pass = request.getParameter("pass");
			String pass1 = request.getParameter("pass1");
			String email = (request.getParameter("email"));
	
			if (pass.equals("") || pass == null || pass1.equals("") || pass1 == null || email.equals("")
					|| email == null) {
				request.setAttribute("mensaje", "Debes rellenar todos los campos");
				request.setAttribute("email", email);
				RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
				dispatcher.forward(request, response);

			} else if (!pass.equals(pass1)) {
				request.setAttribute("mensaje", "La contraseña no coincide");
				request.setAttribute("email", email);
				RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
				dispatcher.forward(request, response);

			} else {
				UserPojo usuario = new UserPojo(0, email, pass);
				modeloUser.addUser(usuario);
				request.setAttribute("email", email);
				request.setAttribute("pass", pass);
				RequestDispatcher dispatcher = request.getRequestDispatcher("editProfile.jsp");
				dispatcher.forward(request, response);
			}
		} else if (accion.equals("insertar")) {
			String nick = request.getParameter("nick");
			String first_name = request.getParameter("first_name");
			String last_name = request.getParameter("last_name");
			Date b_date = Date.valueOf(request.getParameter("b_date"));
			String country = request.getParameter("country");
			String email = request.getParameter("email");
			String pass = request.getParameter("pass");

			UserPojo usuario = new UserPojo(0, nick, first_name, last_name, b_date, country, email, pass);
			modeloUser.updateUser(usuario, modeloUser.getUserIdByEmail(email));
			session = request.getSession(true);
			session.setAttribute("user", usuario);
			RequestDispatcher dispatcher = request.getRequestDispatcher("mercado.jsp");
			dispatcher.forward(request, response);

		} else if (accion.equals("insertarEmail")) {
			String email = request.getParameter("email");
			if (!modeloUser.comprobarSiExisteEmail(email)) {
				if (email != null) {					
					request.setAttribute("email", email);
					RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
					dispatcher.forward(request, response);
				}
			}else {
				request.setAttribute("mensaje", "Este correo ya está en uso");
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			}
		} else if (accion.equals("login")) {
            String emailLogin = request.getParameter("emailLogin");
            String  password= request.getParameter("password");

            if(modeloUser.comprobarSiExisteEmail(emailLogin) && modeloUser.comprobarPassword(modeloUser.getUserIdByEmail(emailLogin)).equals(password)) {
                session = request.getSession(true);
                session.setAttribute("user", modeloUser.getUser(modeloUser.getUserIdByEmail(emailLogin)));

                RequestDispatcher dispatcher = request.getRequestDispatcher("mercado.jsp");
                dispatcher.forward(request, response);
            }else {
                request.setAttribute("mensajeLogin", "Usuario o contraseña invalidos");
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }		
		} else if(accion.equals("cerrarSesion")) {
			session = request.getSession(true);
            session.setAttribute("user", "");
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
			
		
		} else if(accion.equals("recuperarDatosCartera")){
			UserPojo user = (UserPojo) session.getAttribute("user"); // Conversión implicita porque el objeto de sesión que se nos pasa es abstracto y aquí lo definimos como UserPojo.
			request.setAttribute("datosRecuperados", "ok");
			
			request.setAttribute("user", user);
			
			ConexionAPI conexionApi = new ConexionAPI();	
//			System.out.println(conexionApi.infoMonedasUserById(user.getId_user()));
			request.setAttribute("wallet", conexionApi.infoMonedasUserById(user.getId_user()));
			request.setAttribute("precioBit", conexionApi.bitcoinGetter());
				
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("generalPanel.jsp");
            dispatcher.forward(request, response);			
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
