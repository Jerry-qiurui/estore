package com.briup.estore.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.ShopCar;
import com.briup.estore.service.OrderService;

/**
 * Servlet implementation class ToOrderSureServlet
 */
@WebServlet("/toOrderSure")
public class ToOrderSureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToOrderSureServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ShopCar> list = (List<ShopCar>) request.getSession().getAttribute("shopCar");
		Customer cus = (Customer) request.getSession().getAttribute("cus");
		OrderService service = new OrderService();
		service.addOrder(list, cus);
		request.getRequestDispatcher("WEB-INF/orderSure.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
