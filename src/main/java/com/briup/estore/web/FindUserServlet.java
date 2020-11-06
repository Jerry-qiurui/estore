package com.briup.estore.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Customer;
import com.briup.estore.dao.CustomerMapper;
import com.briup.estore.util.MyBatisSqlSessionFactory;

/**
 * Servlet implementation class FindUserServlet
 */
@WebServlet("/findUser")
public class FindUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		PrintWriter pw = response.getWriter();
		if(username != "") {
			SqlSession sqlSession = MyBatisSqlSessionFactory.openSession(true);
			CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
			Customer cus = mapper.SelectUserByName(username);
	//		HashMap<String, Object> map = new HashMap<>();
			if(cus==null) {
				pw.println(1);
	//			map.put("userExist", true);
	//			map.put("msg", "该用户名可注册");
				
			}else {
	//			map.put("userExist", false);
	//			map.put("msg", "该用户名已被注册");
				pw.println(0);
			}
		
		}else {
			pw.println(2);
		}
//		pw.print(map);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
