package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BEAN.User;

@WebServlet("/RegisterForward")
public class RegisterForward extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterForward() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		HttpSession session = request.getSession(false);
		user = (User)session.getAttribute("sessionUser");
		if(user == null) {
			RequestDispatcher rd = request.getRequestDispatcher("./View/Register.jsp");
			rd.forward(request, response);
		}
		else {
			request.getRequestDispatcher("/View/Home.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
