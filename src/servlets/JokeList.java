package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import DaoImpl.PageListDaoImpl;
import beans.JokeBean;
import beans.PageCompute;
/**
 * Servlet implementation class JokeList
 */
@WebServlet(name = "JokeListServlet", urlPatterns = { "/jokelist" })
public class JokeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JokeList() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// http://localhost:8080/JokeWebServer/jokelist?currentPage=1&pageSize=1
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String spage = request.getParameter("currentPage");
		String spageSize = request.getParameter("pageSize");
		if (spage == null || spage == "") {
			spage = "1";
		}
		if (spageSize == null || spageSize == "") {
			spageSize = "10";
		}
		int currentPage = Integer.parseInt(spage);
		int pageSize = Integer.parseInt(spageSize);
		PageCompute<JokeBean> pageCompute = PageListDaoImpl.getRecords(currentPage, pageSize);
        String jsonString = JSONObject.toJSONString(pageCompute);
		out.print(jsonString);
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
