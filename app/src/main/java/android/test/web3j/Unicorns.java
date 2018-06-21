package android.test.web3j;

import java.io.Serializable;
import java.util.ArrayList;

public class Unicorns implements Serializable{

    private int total;
    private int page;
    private ArrayList<Unicorn> items;

    public Unicorns() {
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public ArrayList<Unicorn> getItems() {
        return items;
    }

    public void setItems(ArrayList<Unicorn> items) {
        this.items = items;
    }

    class Location implements Serializable {
        private String lon;
        private String lat;

        public Location() {
        }

        public String getLon() {
            return lon;
        }

        public void setLon(String lon) {
            this.lon = lon;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }
    }

}
