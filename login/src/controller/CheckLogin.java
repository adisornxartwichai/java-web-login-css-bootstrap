package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import connectDB.conDB;

@WebServlet("/CheckLogin")
public class CheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; chartset=utf-8");

		int status = 0;

		try {

			String inputUsername = request.getParameter("username");
			String inputPassword = request.getParameter("password");

			ResultSet result = null;
			Connection con = conDB.connect();

			if (inputUsername != null && inputPassword != null) {
				PreparedStatement pstm = con
						.prepareStatement("SELECT *FROM member WHERE username = ? AND password = ?"); //send sql command to database																									
				pstm.setString(1, inputUsername);
				pstm.setString(2, inputPassword);
				result = pstm.executeQuery();
			}

			while (result.next()) {
				String user = result.getString("username");
				String pass = result.getString("password");

				if (inputUsername.equals(user) && inputPassword.equals(pass)) { 
					response.sendRedirect("https://www.youtube.com"); // url wanna go when logged in success																																	
					status = 1;
				}

			}

			if (status <= 0) {
				response.sendRedirect("login.jsp?error=1");
			}

		} catch (SQLException e) {
			System.err.println("Error database connection: " + e);
			System.exit(0);

		}

	}
}
