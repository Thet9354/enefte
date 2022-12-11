package com.example.enefte.Model;

public class NFTs {

    private String daysLeft, nftType, nftName, artistName, price;
    private int artistProfile, nftImage;
    private Boolean favourite;

    public NFTs(String daysLeft, String nftType, String nftName, String artistName, String price, int artistProfile, int nftImage, Boolean favourite) {
        this.daysLeft = daysLeft;
        this.nftType = nftType;
        this.nftName = nftName;
        this.artistName = artistName;
        this.price = price;
        this.artistProfile = artistProfile;
        this.nftImage = nftImage;
        this.favourite = favourite;
    }

    public String getDaysLeft() {
        return daysLeft;
    }

    public void setDaysLeft(String daysLeft) {
        this.daysLeft = daysLeft;
    }

    public String getNftType() {
        return nftType;
    }

    public void setNftType(String nftType) {
        this.nftType = nftType;
    }

    public String getNftName() {
        return nftName;
    }

    public void setNftName(String nftName) {
        this.nftName = nftName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getArtistProfile() {
        return artistProfile;
    }

    public void setArtistProfile(int artistProfile) {
        this.artistProfile = artistProfile;
    }

    public int getNftImage() {
        return nftImage;
    }

    public void setNftImage(int nftImage) {
        this.nftImage = nftImage;
    }

    public Boolean getFavourite() {
        return favourite;
    }

    public void setFavourite(Boolean favourite) {
        this.favourite = favourite;
    }
}
