package com.nt.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.controller.LinksController;

@WebServlet
public class NitFrontControllerServlet extends HttpServlet {

	private LinksController controller = null;

	public void init() throws ServletException {
		controller = new LinksController();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Navigation Management
		String lvn = null;

		if (request.getServletPath().equalsIgnoreCase("/wish"))
			lvn = controller.showWishMessage(request);
		else if (request.getServletPath().equalsIgnoreCase("/lang"))
			lvn = controller.showAllLanguages(request);
		else
			lvn = "home";
		
		//View Management
		String destPage = null;
		if (lvn.equalsIgnoreCase("wish_result"))
			destPage = "/show_wish.jsp";
		else if (lvn.equalsIgnoreCase("all_lang"))
			destPage = "/show_languages.jsp";
		else
			destPage="/index.jsp";

		//Forward the request to destination page
		RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
		dispatcher.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
