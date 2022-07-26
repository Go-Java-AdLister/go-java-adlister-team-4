package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.CreateAdServlet", urlPatterns = "/ads/create")
public class CreateAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/ads/create.jsp")
            .forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = (User) request.getSession().getAttribute("user");

        Ad ad = new Ad(
            user.getId(),
            request.getParameter("category"),
            request.getParameter("plant_name"),
            request.getParameter("location"),
            request.getParameter("price"),
            request.getParameter("description"),
            request.getParameter("photo")
        );
        System.out.println(ad.getPhoto());

        System.out.println(ad.getDescription());

        //if statement for giving alert if no commenet
        DaoFactory.getAdsDao().insert(ad);
        response.sendRedirect("/ads");
    }
}
