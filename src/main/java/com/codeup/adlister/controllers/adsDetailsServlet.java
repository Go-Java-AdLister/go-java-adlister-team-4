package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ads/details")
public class adsDetailsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        long id = Long.parseLong(request.getParameter("id"));
        request.setAttribute("ads", DaoFactory.getAdsDao().findByID(id));

//This hides the edit and delete buttons if a user is not logged in or is not the creator of the ad
        User user = null;
        Ad ad = DaoFactory.getAdsDao().findByID(id);

        if (session != null) {
            user = (User) session.getAttribute("user");
        }
        if (user != null && user.getId() == ad.getUserId()) {
            request.setAttribute("edit", "<button class = \"button\" type=\"submit\">Edit</button>\n");
        } else {
            request.setAttribute("edit", "");
        }

        if (session != null) {
            user = (User) session.getAttribute("user");
        }
        if (user != null && user.getId() == ad.getUserId()) {
            request.setAttribute("delete",
                    "<input class = \"button\" value=\"delete\" type=\"submit\">\n");
        } else {
            request.setAttribute("delete", "");
        }

        request.getRequestDispatcher("/WEB-INF/ads/adsDetails.jsp").forward(request, response);
    }
}
