package com.example.enefte.Model;

public class CollectionsItemNft {

    private int id;
    private String nftArtist;
    private String nftName;
    private String ethPrice;
    private int nftImage;


    public CollectionsItemNft(int id, String nftArtist, String nftName, String ethPrice, int nftImage) {
        this.id = id;
        this.nftArtist = nftArtist;
        this.nftName = nftName;
        this.ethPrice = ethPrice;
        this.nftImage = nftImage;
    }

    public CollectionsItemNft() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNftArtist() {
        return nftArtist;
    }

    public void setNftArtist(String nftArtist) {
        this.nftArtist = nftArtist;
    }

    public String getNftName() {
        return nftName;
    }

    public void setNftName(String nftName) {
        this.nftName = nftName;
    }

    public String getEthPrice() {
        return ethPrice;
    }

    public void setEthPrice(String ethPrice) {
        this.ethPrice = ethPrice;
    }

    public int getNftImage() {
        return nftImage;
    }

    public void setNftImage(int nftImage) {
        this.nftImage = nftImage;
    }
}
