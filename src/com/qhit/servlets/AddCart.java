package com.qhit.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qhit.beans.Goods;
import com.qhit.dao.GoodsDao;

/**
 * Servlet implementation class AddCart
 */
public class AddCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("cart");
		Map<String,Goods> cart; 
		if(null == obj){
			cart = new HashMap<String,Goods>();
		}else{
			cart = (Map<String,Goods>)obj;
		}
		
		GoodsDao dao = new GoodsDao();
		Goods goods = dao.getGoodsById(Integer.parseInt(id));
		
		if(cart.containsKey(id)){
			Goods oldGoods = cart.get(id);
			oldGoods.setNum(oldGoods.getNum() + 1);
		}else{
			goods.setNum(1);
			cart.put(id, goods);
		}
		session.setAttribute("cart", cart);
		response.sendRedirect("QueryGoodsServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
