package com.example.rakesh.locate_hdfc_atm;

public class Atm {
    private int no;
    private String add;
    private String locality;
    private String city;
    private String phoneno;
    private double lat,lon;

    public Atm(int no, String add, String locality, String city, String phoneno, double lat, double lon) {
        this.no = no;
        this.add = add;
        this.locality = locality;
        this.city = city;
        this.phoneno = phoneno;
        this.lat = lat;
        this.lon = lon;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
