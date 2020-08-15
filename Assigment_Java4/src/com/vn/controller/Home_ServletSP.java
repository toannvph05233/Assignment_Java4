package com.vn.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vn.model.Product;
import com.vn.service.Controller_SP;
import com.vn.service.ProductService;


@WebServlet(name = "Home_ServletSP", urlPatterns = {"/home"})
public class Home_ServletSP extends HttpServlet {
    Controller_SP controller_sp = new Controller_SP();
    ArrayList<Product> listSP = (ArrayList<Product>) new ProductService().getAllProduct();
    
  


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String nguoiDung = request.getParameter("nguoiDung");

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    createSP(request, response);
                } catch (ParseException e) {
                    System.out.println("no");
                    e.printStackTrace();
                }
                break;
            case "edit":
                try {
                    updateSP(request, response);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            default:
                listStudet(request, response);
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
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            case "view":
                viewStudent(request, response);
                break;
            default:
                listStudet(request, response);
                break;
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("listSP", listSP);
        RequestDispatcher dispatcher;
        dispatcher = request.getRequestDispatcher("createSP.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void viewStudent(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher;
        request.setAttribute("listSP", listSP);
        dispatcher = request.getRequestDispatcher("listSP.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        String idSP = request.getParameter("id");
        Product sanPham = controller_sp.findByIdSP(listSP, idSP);
        int id = controller_sp.findIdSP(listSP, idSP);
        RequestDispatcher dispatcher;
        if (sanPham == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            this.controller_sp.deleteSP(listSP, id);
            try {
                response.sendRedirect("home");
//                request.getRequestDispatcher("listSP.jsp").forward(request,response);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        String idSP = request.getParameter("id");
        Product sanPham = controller_sp.findByIdSP(listSP, idSP);
        //int id = controller_sp.findIdSP(listSP,idSP);
        RequestDispatcher dispatcher;
        if (sanPham == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("sanPham", sanPham);
            dispatcher = request.getRequestDispatcher("delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateSP(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        String getidSP = request.getParameter("id");
        int id = controller_sp.findIdSP(listSP, getidSP);

        String idSP = request.getParameter("idSP");
        String idLSP = request.getParameter("idLSP");
        String nameSP = request.getParameter("nameSP");
        float giaSP = Float.parseFloat(request.getParameter("giaSP"));
        java.sql.Date dateSP  = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        String imgSP = request.getParameter("imgSP");
        Product sanPham = this.controller_sp.findByIdSP(listSP, getidSP);
        RequestDispatcher dispatcher;
        if (sanPham == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            sanPham.setIdSanPham(idSP);
            sanPham.setIdLoaiSanPham(idLSP);
            sanPham.setNameSP(nameSP);
            sanPham.setGiaSP(giaSP);
            sanPham.setImgSP(imgSP);
            sanPham.setDateNhap(dateSP);
            this.controller_sp.editSP(listSP, sanPham, id);

            request.setAttribute("listSP", listSP);
            dispatcher = request.getRequestDispatcher("index.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        String idSP = request.getParameter("id");
        Product sanPham = controller_sp.findByIdSP(listSP, idSP);
        RequestDispatcher dispatcher;
        if (sanPham == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("sanPham", sanPham);
            dispatcher = request.getRequestDispatcher("edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createSP(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        String idSP = request.getParameter("idSP");
        String idLSP = request.getParameter("idLSP");
        String nameSP = request.getParameter("nameSP");
        float giaSP = Float.parseFloat(request.getParameter("giaSP"));
        java.sql.Date dateSP  = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        String imgSP = request.getParameter("imgSP");

        RequestDispatcher dispatcher;
        Product sanPham = new Product(idSP, idLSP, nameSP, giaSP, dateSP, imgSP);
        this.controller_sp.createSP(listSP, sanPham);
        
        request.setAttribute("listSP", listSP);

        dispatcher = request.getRequestDispatcher("index.jsp");

        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void listStudet(HttpServletRequest request, HttpServletResponse response) {
    	System.out.println(listSP.size()+"llllllllllllllllllllllllllllllllll");
        request.setAttribute("listSP", listSP);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
