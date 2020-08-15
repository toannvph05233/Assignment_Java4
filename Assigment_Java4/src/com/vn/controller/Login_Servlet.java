package com.vn.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vn.model.NguoiDungEntity;
import com.vn.service.Controller_ND;
import com.vn.service.NguoiDungService;

@WebServlet(name = "Login_Servlet", urlPatterns = {"/login"})
public class Login_Servlet extends HttpServlet {
    Controller_ND controller_nd = new Controller_ND();
   
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        

		ArrayList<NguoiDungEntity> listND = (ArrayList<NguoiDungEntity>) new NguoiDungService().loginNguoiDung(user,password);
		
		
            if (listND != null) {
            	NguoiDungEntity nd = listND.get(0);
                if (nd.getIdLoaiAcout() == 1) {
                    request.setAttribute("fullNameND", nd.getFullName());
                    dispatcher = request.getRequestDispatcher("home");
                    session.setAttribute("nd", listND.get(0));
                    dispatcher.forward(request, response);
                    return;
                } else {
                    if (nd.getIdLoaiAcout() == 2) {
                        request.setAttribute("fullNameND", nd.getFullName());
                        dispatcher = request.getRequestDispatcher("homeuser");
                        session.setAttribute("nd", listND.get(0));
                        dispatcher.forward(request, response);
                        return;
                    }
                }
            }
        
        dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }
}
