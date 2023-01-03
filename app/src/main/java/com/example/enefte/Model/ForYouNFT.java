package com.example.enefte.Model;

public class ForYouNFT {

    private int id;
    private String nftName;
    private String nftArtist;
    private int nftImage;

    public ForYouNFT(int id, String nftName, String nftArtist, int nftImage) {
        this.id = id;
        this.nftName = nftName;
        this.nftArtist = nftArtist;
        this.nftImage = nftImage;
    }

    public ForYouNFT()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getNftImage() {
        return nftImage;
    }

    public void setNftImage(int nftImage) {
        this.nftImage = nftImage;
    }
}
