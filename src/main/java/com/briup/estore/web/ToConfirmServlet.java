package com.briup.estore.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.briup.estore.bean.ShopCar;

/**
 * Servlet implementation class ToConfirmServlet
 */
@WebServlet("/toConfirm")
public class ToConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToConfirmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ShopCar> list = (List<ShopCar>) request.getSession().getAttribute("shopCar");
		int num = 0;
		double price = 0.0;
		for (ShopCar shopCar : list) {
			num += shopCar.getNum();
			price += (shopCar.getNum() * shopCar.getBook().getPrice());
		}
		int iprice = (int)price;
		request.getRequestDispatcher("WEB-INF/confirm.jsp?num="+ num +"&price=" + iprice).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
