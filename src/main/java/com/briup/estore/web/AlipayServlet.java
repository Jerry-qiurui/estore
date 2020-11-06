package com.briup.estore.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;

/**
 * Servlet implementation class AlipayServlet
 */
@WebServlet("/alipay")
public class AlipayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlipayServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AlipayClient client = AlipayConfig.getAlipayClient();
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
		AlipayTradePagePayModel model = new AlipayTradePagePayModel();
		//设置订单号
			model.setOutTradeNo(System.currentTimeMillis()+"");
			//设置支付金额
			String price = request.getParameter("price");
			model.setTotalAmount(price);
			// 订单名字
			model.setSubject("书籍订单");
			// 订单描述 
			model.setBody(System.currentTimeMillis()+"");
			// 产品码 
			model.setProductCode("FAST_INSTANT_TRADE_PAY");
			// 设置参数 
			alipayRequest.setBizModel(model);
			// 设置回调地址 
			alipayRequest.setReturnUrl(request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/"+"toOrderSure");
			String result;
			try {
				result = client.pageExecute(alipayRequest).getBody();
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().println(result);
			} catch (AlipayApiException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
