package com.delacruz.hanz;

public class Grade {
    String fname, lname;
    double average;

    public Grade(String fname, String lname, double average) {
        this.fname = fname;
        this.lname = lname;
        this.average = average;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public double getaverage() {
        return average;
    }

    public void setaverage(double average) {
        this.average = average;
    }
}




