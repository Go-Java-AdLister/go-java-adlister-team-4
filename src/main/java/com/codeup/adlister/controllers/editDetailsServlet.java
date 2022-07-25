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

@WebServlet("/ads/details/edit")
public class editDetailsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long id = Long.parseLong(request.getParameter("id"));

        request.setAttribute("ads", DaoFactory.getAdsDao().findByID(id));
        request.getRequestDispatcher("/WEB-INF/ads/edit.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        User user = (User) request.getSession().getAttribute("user");
        String editCat = request.getParameter("category");
        String editName = request.getParameter("plant_name");
        String editLocation = request.getParameter("location");
        String editPrice = request.getParameter("price");
        String editDescription = request.getParameter("description");
        String editPhoto = request.getParameter("photo");
        long id = Long.parseLong(request.getParameter("id"));

        Ad ad = new Ad (
                id, user.getId(), editCat, editName, editLocation, editPrice, editDescription, editPhoto
        );
        DaoFactory.getAdsDao().editAd(ad);
        response.sendRedirect("/ads");

}}
