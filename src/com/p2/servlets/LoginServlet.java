package com.p2.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.p2.dao.LoginDao;

public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)  
			throws ServletException, IOException {  

		response.setContentType("text/html");  
            try (PrintWriter out = response.getWriter()) {
                String n=request.getParameter("username");
                String p=request.getParameter("userpass");
                
                HttpSession session = request.getSession(false);
                if(session!=null)
                    session.setAttribute("name", n);
                
                if(LoginDao.validate(n, p)){
                    RequestDispatcher rd=request.getRequestDispatcher("bemVindo.jsp");
                    rd.forward(request,response);
                }               
                else{                    
                    RequestDispatcher rd=request.getRequestDispatcher("erroLogin.jsp");
                    rd.include(request,response);                    
                }                
                
            }  
	}  
}  