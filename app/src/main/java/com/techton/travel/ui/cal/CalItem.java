package com.techton.travel.ui.cal;

public class CalItem {
    String name;
    String address;
    String order;

    public CalItem( String o, String n, String a){
        this.name=n;
        this.address=a;
        this.order=o;
    }

    public String getName() {
        return name;
    }
    public String getAddress() {return address;}
    public String getOrder() {return order;}
}
