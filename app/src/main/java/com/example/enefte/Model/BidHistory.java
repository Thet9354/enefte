package com.example.enefte.Model;

public class BidHistory {

    private int id;
    private int bidAccImage;
    private String accName;
    private String bidEthPrice;
    private String duration;
    private String bidUsdPrice;
    private String floorDiff;
    private String expiration;

    public BidHistory(int id, int bidAccImage, String accName, String bidEthPrice, String duration, String bidUsdPrice, String floorDiff, String expiration) {
        this.id = id;
        this.bidAccImage = bidAccImage;
        this.accName = accName;
        this.bidEthPrice = bidEthPrice;
        this.duration = duration;
        this.bidUsdPrice = bidUsdPrice;
        this.floorDiff = floorDiff;
        this.expiration = expiration;
    }

    public BidHistory() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBidAccImage() {
        return bidAccImage;
    }

    public void setBidAccImage(int bidAccImage) {
        this.bidAccImage = bidAccImage;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getBidEthPrice() {
        return bidEthPrice;
    }

    public void setBidEthPrice(String bidEthPrice) {
        this.bidEthPrice = bidEthPrice;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getBidUsdPrice() {
        return bidUsdPrice;
    }

    public void setBidUsdPrice(String bidUsdPrice) {
        this.bidUsdPrice = bidUsdPrice;
    }

    public String getFloorDiff() {
        return floorDiff;
    }

    public void setFloorDiff(String floorDiff) {
        this.floorDiff = floorDiff;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }
}
