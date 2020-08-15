package com.vn.controller;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vn.model.NguoiDungEntity;
import com.vn.service.Controller_ND;
import com.vn.service.NguoiDungService;



@WebServlet(name = "Home_ServletND", urlPatterns = {"/homeND"})
public class Home_ServletND extends HttpServlet {
    Controller_ND controller_nd = new Controller_ND();
    ArrayList<NguoiDungEntity> listND = (ArrayList<NguoiDungEntity>) new NguoiDungService().getAllNguoiDung();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createND(request, response);
                break;
            case "edit":
                updateND(request, response);
                break;
            case "delete":
                deleteND(request, response);
                break;
            default:
                showlistND(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateND(request, response);
                break;
            case "edit":
                showEditND(request, response);
                break;
            case "delete":
                showDeleteND(request, response);
                break;
            default:
                showlistND(request, response);
                break;
        }
    }

    private void showCreateND(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("listND", listND);
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("createND.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showlistND(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher;
        request.setAttribute("listND", listND);
        dispatcher = request.getRequestDispatcher("quanly_user/listND.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteND(HttpServletRequest request, HttpServletResponse response) {
        String user = request.getParameter("id");
        NguoiDungEntity nguoiDung = controller_nd.findByIdND(listND, user);
        int id = controller_nd.findIndexND(listND, user);
        RequestDispatcher dispatcher;
        if (nguoiDung == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            this.controller_nd.deleteND(listND, id);
            try {
                response.sendRedirect("homeND");
//                request.getRequestDispatcher("listSP.jsp").forward(request,response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showDeleteND(HttpServletRequest request, HttpServletResponse response) {
        String user = request.getParameter("id");
        NguoiDungEntity nguoiDung = controller_nd.findByIdND(listND, user);

        RequestDispatcher dispatcher;
        if (nguoiDung == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("nguoiDung", nguoiDung);
            dispatcher = request.getRequestDispatcher("quanly_user/deleteND.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateND(HttpServletRequest request, HttpServletResponse response) {
        String user = request.getParameter("id");
        NguoiDungEntity nguoiDung = controller_nd.findByIdND(listND, user);
        int id = controller_nd.findIndexND(listND, user);

        String userND = request.getParameter("user");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        int sdt = Integer.parseInt(request.getParameter("sdt"));


        RequestDispatcher dispatcher;
        if (nguoiDung == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            nguoiDung.setIdUser(userND);
            nguoiDung.setPassword(password);
            nguoiDung.setFullName(fullname);
            nguoiDung.setSdt(sdt);

            this.controller_nd.editND(listND, nguoiDung, id);

            request.setAttribute("listND", listND);
            dispatcher = request.getRequestDispatcher("quanly_user/listND.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditND(HttpServletRequest request, HttpServletResponse response) {
        String user = request.getParameter("id");
        NguoiDungEntity nguoiDung = controller_nd.findByIdND(listND, user);
        RequestDispatcher dispatcher;
        if (nguoiDung == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("nguoiDung", nguoiDung);
            dispatcher = request.getRequestDispatcher("quanly_user/editND.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createND(HttpServletRequest request, HttpServletResponse response) {
        String userND = request.getParameter("userND");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        int sdt = Integer.parseInt(request.getParameter("sdt"));
        int idloaiuser = Integer.parseInt(request.getParameter("idloaiuser"));
        String loaiuser = request.getParameter("loaiuser");

        RequestDispatcher dispatcher;
        NguoiDungEntity nguoiDung = new NguoiDungEntity(userND, password, fullname, sdt,idloaiuser);
        this.controller_nd.createND(listND, nguoiDung);
        request.setAttribute("listND", listND);

        dispatcher = request.getRequestDispatcher("quanly_user/listND.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
