package com.example.enefte.Model;

public class CollectionsActivityNft {

    private int id;
    private int nftImage;

    private String nftArtist;
    private String nftName;
    private String nftStatus;
    private String nftPrice;
    private String nftDuration;
    private String nftUSDPrice;
    private String nftQuantity;
    private String nftFrom;
    private String nftTo;


    public CollectionsActivityNft(int id, int nftImage, String nftArtist, String nftName, String nftStatus, String nftPrice, String nftDuration, String nftUSDPrice, String nftQuantity, String nftFrom, String nftTo) {
        this.id = id;
        this.nftImage = nftImage;
        this.nftArtist = nftArtist;
        this.nftName = nftName;
        this.nftStatus = nftStatus;
        this.nftPrice = nftPrice;
        this.nftDuration = nftDuration;
        this.nftUSDPrice = nftUSDPrice;
        this.nftQuantity = nftQuantity;
        this.nftFrom = nftFrom;
        this.nftTo = nftTo;
    }

    public CollectionsActivityNft() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNftImage() {
        return nftImage;
    }

    public void setNftImage(int nftImage) {
        this.nftImage = nftImage;
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

    public String getNftStatus() {
        return nftStatus;
    }

    public void setNftStatus(String nftStatus) {
        this.nftStatus = nftStatus;
    }

    public String getNftPrice() {
        return nftPrice;
    }

    public void setNftPrice(String nftPrice) {
        this.nftPrice = nftPrice;
    }

    public String getNftDuration() {
        return nftDuration;
    }

    public void setNftDuration(String nftDuration) {
        this.nftDuration = nftDuration;
    }

    public String getNftUSDPrice() {
        return nftUSDPrice;
    }

    public void setNftUSDPrice(String nftUSDPrice) {
        this.nftUSDPrice = nftUSDPrice;
    }

    public String getNftQuantity() {
        return nftQuantity;
    }

    public void setNftQuantity(String nftQuantity) {
        this.nftQuantity = nftQuantity;
    }

    public String getNftFrom() {
        return nftFrom;
    }

    public void setNftFrom(String nftFrom) {
        this.nftFrom = nftFrom;
    }

    public String getNftTo() {
        return nftTo;
    }

    public void setNftTo(String nftTo) {
        this.nftTo = nftTo;
    }
}
