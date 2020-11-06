package com.briup.estore.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.bean.Order;
import com.briup.estore.bean.OrderLine;
import com.briup.estore.service.OrderService;

/**
 * Servlet implementation class ToOrderServlet
 */
@WebServlet("/toOrder")
public class ToOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Customer cus = (Customer) request.getSession().getAttribute("cus");
		OrderService service = new OrderService();
		List<Order> list = service.selectByCus(cus);
		HashMap<Order, List<OrderLine>> map = new HashMap<>();
		for (Order order : list) {
			List<OrderLine> list2 = service.selectLineByOrder(order);
			String id = order.getId();
			map.put(order, list2);
		}
		HttpSession session = request.getSession();
		session.setAttribute("orderMaps", map);
		request.getRequestDispatcher("WEB-INF/order.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
