package Backend.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Backend.DAO.UserDAO;

/**
 * Servlet implementation class SignUpController
 */
@WebServlet("path_of_sign_up_page")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void init() throws ServletException {
		super.init();
		new UserDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		String phoneNumber = request.getParameter("phoneNumber");
		
		doGet(request, response);
	}

}
