package com.wx.assigntask.comment;

public class Item {
    public String item,des;
    public Item(){

    }

    public void Item(String item,String des){
        this.des = des;
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
