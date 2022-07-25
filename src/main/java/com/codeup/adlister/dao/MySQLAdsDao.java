package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, category, plant_name, location, price, description, photo) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getCategory());
            stmt.setString(3, ad.getPlant_name());
            stmt.setString(4, ad.getLocation());
            stmt.setString(5, ad.getPrice());
            stmt.setString(6, ad.getDescription());
            stmt.setString(7, ad.getPhoto());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("category"),
                rs.getString("plant_name"),
                rs.getString("location"),
                rs.getString("price"),
                rs.getString("description"),
                rs.getString("photo")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }

//    implementing findOne method from ads.java to show a detailed ad post


    @Override
    // Finds ad by its id and pulls it out for use
    public Ad findByID(long id) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads WHERE id = ? ");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return extractAd(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Ad editAd(Ad ad) {
        PreparedStatement stmt = null;


        try {
            //connects to database to find each column associated with a specific ID so that it can be updated
            stmt = connection.prepareStatement("UPDATE ads SET category = ?, plant_name = ?, location = ?, price = ?, description = ?, photo = ? WHERE id = ? ");


            stmt.setString(1, ad.getCategory());
            stmt.setString(2, ad.getPlant_name());
            stmt.setString(3, ad.getLocation());
            stmt.setString(4, ad.getPrice());
            stmt.setString(5, ad.getDescription());
            stmt.setString(6, ad.getPhoto());
            stmt.setLong(7, ad.getId());


            stmt.executeUpdate();
            return ad;
        } catch (SQLException e) {
            throw new RuntimeException("Error updating ads.", e);
        }
    }

    @Override
    public void deleteAd(long id) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("DELETE FROM ads WHERE id = ? ");
            stmt.setLong(1, id);
            stmt.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException("Error deleting ad.", e);
        }
    }


}
