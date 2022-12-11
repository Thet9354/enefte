package com.example.enefte.Model;

public class NFTCollector {

    private int id;
    private int collectorImage;

    private String collectorName;
    private String collectorUserName;
    private String ethereumBalance;
    private String ethereumChange;

    private Boolean profit;

    public NFTCollector(int id, int collectorImage, String collectorName, String collectorUserName, String ethereumBalance, String ethereumChange, Boolean profit) {
        this.id = id;
        this.collectorImage = collectorImage;
        this.collectorName = collectorName;
        this.collectorUserName = collectorUserName;
        this.ethereumBalance = ethereumBalance;
        this.ethereumChange = ethereumChange;
        this.profit = profit;
    }

    public NFTCollector()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCollectorImage() {
        return collectorImage;
    }

    public void setCollectorImage(int collectorImage) {
        this.collectorImage = collectorImage;
    }

    public String getCollectorName() {
        return collectorName;
    }

    public void setCollectorName(String collectorName) {
        this.collectorName = collectorName;
    }

    public String getCollectorUserName() {
        return collectorUserName;
    }

    public void setCollectorUserName(String collectorUserName) {
        this.collectorUserName = collectorUserName;
    }

    public String getEthereumBalance() {
        return ethereumBalance;
    }

    public void setEthereumBalance(String ethereumBalance) {
        this.ethereumBalance = ethereumBalance;
    }

    public String getEthereumChange() {
        return ethereumChange;
    }

    public void setEthereumChange(String ethereumChange) {
        this.ethereumChange = ethereumChange;
    }

    public Boolean getProfit() {
        return profit;
    }

    public void setProfit(Boolean profit) {
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "NFTCollector{" +
                "id=" + id +
                ", collectorImage=" + collectorImage +
                ", collectorName='" + collectorName + '\'' +
                ", collectorUserName='" + collectorUserName + '\'' +
                ", ethereumBalance='" + ethereumBalance + '\'' +
                ", ethereumChange='" + ethereumChange + '\'' +
                ", profit=" + profit +
                '}';
    }
}
