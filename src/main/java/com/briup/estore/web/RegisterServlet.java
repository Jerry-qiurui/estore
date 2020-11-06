package com.briup.estore.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Customer;
import com.briup.estore.service.CustomerService;
import com.briup.estore.util.EstoreException;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private CustomerService service;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        service = new CustomerService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String rname = request.getParameter("username");
		String rpwd = request.getParameter("password");
		String rzip = request.getParameter("zip");
		String raddress = request.getParameter("address");
		String rtel = request.getParameter("tel");
		String remail = request.getParameter("email");
		Customer cus = new Customer(rname, rpwd, rzip, raddress, rtel, remail);

		try {
			service.register(cus);
		} catch (EstoreException e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("toRegister").forward(request, response);
		}
		request.getRequestDispatcher("toLogin").forward(request, response);;
	}

}
