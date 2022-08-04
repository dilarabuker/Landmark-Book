package com.dilarabkr.landmarkbook;

import java.io.Serializable;

public class Landmark implements Serializable {


    String name;
    String country;
    int image; //android studio her görsele bir integer atıyo bu yüzden int dedik..

    //constructor

    public  Landmark (String name, String country, int image) {
        this.name=name;
        this.country=country;
        this.image=image;


    }
}
