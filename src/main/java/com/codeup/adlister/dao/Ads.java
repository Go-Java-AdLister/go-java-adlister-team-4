package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();

    // insert a new ad and return the new ad's id
    Long insert(Ad ad);

    //   adding abstract method to the interface to display ad detailed page

    Ad findByID(long id);

    // finds the ad id
    void deleteAd(long id);

    Ad editAd(Ad ad);

}
