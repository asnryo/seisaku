package admin.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

/**
 * Servlet implementation class AdminUserDeleteServlet
 */
@WebServlet("/AdminUserDeleteServlet")
public class AdminUserDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUserDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }public void doGet(HttpServletRequest request,HttpServletResponse response)
        		 throws IOException, ServletException
        		 {
				this.doPost(request, response);
        		 }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {

    		String userid = request.getParameter("id");

    		try (UserDAO dao = new UserDAO()) {

    			 dao.delete(userid);


    		} catch (Exception e) {
    			throw new ServletException(e);
    		}
    		setMessage(request,"id[ " + userid + " ]の削除処理が完了しました");


    		RequestDispatcher rd = request.getRequestDispatcher("AdminUserSerchServlet");
    		rd.forward(request, response);
    	}
    		protected void setMessage(HttpServletRequest request, String message) {
    			request.setAttribute("message", message);
    	}
    }