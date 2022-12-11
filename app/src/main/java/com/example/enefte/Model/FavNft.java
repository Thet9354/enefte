package com.example.enefte.Model;

public class FavNft {

    private String nftName;
    private String nftArtist;
    private String nftID;
    private int nftImage;
    private int nftArtistImage;
    private String nftCategory;

    public FavNft(String nftName, String nftArtist, String nftID, int nftImage, int nftArtistImage, String nftCategory) {
        this.nftName = nftName;
        this.nftArtist = nftArtist;
        this.nftID = nftID;
        this.nftImage = nftImage;
        this.nftArtistImage = nftArtistImage;
        this.nftCategory = nftCategory;
    }

    public FavNft()
    {

    }

    public int getNftArtistImage() {
        return nftArtistImage;
    }

    public void setNftArtistImage(int nftArtistImage) {
        this.nftArtistImage = nftArtistImage;
    }

    public String getNftName() {
        return nftName;
    }

    public void setNftName(String nftName) {
        this.nftName = nftName;
    }

    public String getNftArtist() {
        return nftArtist;
    }

    public void setNftArtist(String nftArtist) {
        this.nftArtist = nftArtist;
    }

    public String getNftID() {
        return nftID;
    }

    public void setNftID(String nftID) {
        this.nftID = nftID;
    }

    public int getNftImage() {
        return nftImage;
    }

    public void setNftImage(int nftImage) {
        this.nftImage = nftImage;
    }

    public String getNftCategory() {
        return nftCategory;
    }

    public void setNftCategory(String nftCategory) {
        this.nftCategory = nftCategory;
    }

    @Override
    public String toString() {
        return "FavNft{" +
                "nftName='" + nftName + '\'' +
                ", nftArtist='" + nftArtist + '\'' +
                ", nftID='" + nftID + '\'' +
                ", nftImage=" + nftImage +
                ", nftCategory='" + nftCategory + '\'' +
                '}';
    }
}
