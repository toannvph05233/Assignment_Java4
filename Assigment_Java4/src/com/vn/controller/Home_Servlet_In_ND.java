package com.vn.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vn.model.HoaDon;
import com.vn.model.HoaDonChiTiet;
import com.vn.model.NguoiDungEntity;
import com.vn.model.Product;
import com.vn.service.Controller_SP;
import com.vn.service.HoaDonChiTietService;
import com.vn.service.HoaDonService;
import com.vn.service.ProductService;

@WebServlet(name = "Home_Servlet_User", urlPatterns = { "/homeuser" })
public class Home_Servlet_In_ND extends HttpServlet {
	Controller_SP controller_sp = new Controller_SP();
	ArrayList<Product> listSP = (ArrayList<Product>) new ProductService().getAllProduct();
	ArrayList<Product> listSPMua = new ArrayList<>();
	HoaDonService hoaDonService = new HoaDonService();
	HoaDonChiTietService hoaDonChiTietService = new HoaDonChiTietService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher;

		String action = request.getParameter("action");

		if (action == null) {
			action = "";
		}
		switch (action) {
		default:
			request.setAttribute("listSP", listSP);
			String fullName = request.getParameter("fullNameND");
			request.setAttribute("fullNameND", fullName);
			dispatcher = request.getRequestDispatcher("web_User/index_User.jsp");
			dispatcher.forward(request, response);
			break;
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (action == null) {
			action = "";
		}
		switch (action) {
		case "addgiohang":
			addGioHang(request, response);
			break;
		case "delete":
			deleteGioHang(request, response);
			break;
		case "muasp":
			showBuySanPham(request, response);
			break;
		case "muahang":
			buySanPham(request, response);
			break;
		default:
			RequestDispatcher dispatcher;
			request.setAttribute("listSP", listSP);
			dispatcher = request.getRequestDispatcher("web_User/index_User.jsp");
			dispatcher.forward(request, response);
			break;
		}
	}

	private void addGioHang(HttpServletRequest request, HttpServletResponse response) {
		String iduser = request.getParameter("id");
		Product sanPhamMua = controller_sp.findByIdSP(listSP, iduser);
		RequestDispatcher dispatcher;

		if (sanPhamMua == null) {
			dispatcher = request.getRequestDispatcher("error-404.jsp");
		} else {
			listSPMua.add(sanPhamMua);
			request.setAttribute("listSPMua", listSPMua);
			dispatcher = request.getRequestDispatcher("giohang.jsp");
		}
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void deleteGioHang(HttpServletRequest request, HttpServletResponse response) {
		String idSP = request.getParameter("id");
		Product sanPham = controller_sp.findByIdSP(listSPMua, idSP);
		int id = controller_sp.findIdSP(listSPMua, idSP);
		RequestDispatcher dispatcher;
		if (sanPham == null) {
			dispatcher = request.getRequestDispatcher("error-404.jsp");
		} else {
			this.controller_sp.deleteSP(listSPMua, id);
			try {
				response.sendRedirect("homeuser");
//                request.getRequestDispatcher("listSP.jsp").forward(request,response);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void showBuySanPham(HttpServletRequest request, HttpServletResponse response) {
		RequestDispatcher dispatcher;
		request.setAttribute("listSPMua", listSPMua);
		dispatcher = request.getRequestDispatcher("muaSanPham.jsp");

		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void buySanPham(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		NguoiDungEntity nd = (NguoiDungEntity) session.getAttribute("nd");
		String idUser = nd.getIdUser();
		System.out.println(idUser+"llllllllllllllllllll");
		
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		String name = idUser + new java.util.Date(millis);
		
		HoaDon hoaDon = new HoaDon();
		hoaDon.setIdUser(idUser);
		hoaDon.setDateLap(date);
		hoaDon.setName(name);
		hoaDonService.saveHoaDon(hoaDon);

		List<HoaDon> listHD = hoaDonService.findHoaDonBy(name);

		for (Product product : listSPMua) {
			HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
			hoaDonChiTiet.setGiaSP(product.getGiaSP());
			hoaDonChiTiet.setIdHoaDon(listHD.get(0).getIdHoaDon());
			hoaDonChiTiet.setIdSanPham(product.getIdSanPham());
			hoaDonChiTiet.setSoLuong(1);

			hoaDonChiTietService.saveHoaDonChiTiet(hoaDonChiTiet);
		}
		for (int i = 0; i < listSPMua.size(); i++) {
			listSPMua.remove(i);
		}
		try {
			response.sendRedirect("homeuser");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
