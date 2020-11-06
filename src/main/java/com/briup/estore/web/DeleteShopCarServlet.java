package com.briup.estore.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.dao.ShopCarMapper;
import com.briup.estore.util.MyBatisSqlSessionFactory;

/**
 * Servlet implementation class DeleteShopCar
 */
@WebServlet("/deleteShopCar")
public class DeleteShopCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteShopCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Integer bId = Integer.parseInt(id);
		HttpSession session = request.getSession();
		Object customer = session.getAttribute("cus");
		Customer cus = (Customer)customer;
		String username = cus.getUsername();
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession(true);
		ShopCarMapper mapper = sqlSession.getMapper(ShopCarMapper.class);
		mapper.delete(username, bId);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
