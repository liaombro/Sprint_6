package com.example;

import java.util.List;

public class AlexTheLion extends Lion {
    private List<String> friends;
    private String placeOfLiving;
    private int kittenCount;

    public AlexTheLion(Feline feline) throws Exception {
        super(feline, "Самец");
        this.friends = List.of("Марти","Глория","Мелман");
        this.placeOfLiving = "Нью-Йоркский зоопарк";
        this.kittenCount = 0;
    }


    @Override
    public int getKittens() {
        return feline.getKittens(kittenCount);
    }

    public String getPlaceOfLiving() {
        return placeOfLiving;
    }

    public List<String> getFriends() {
        return friends;
    }
}
