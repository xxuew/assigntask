package com.wx.assigntask.comment;

public class ItemList {
    public String itema,itemb;
    public int scorea,scoreb;
    public void ItemList(){

    }
    public void ItemList(String itema,String itemb){
        this.itema = itema;
        this.itemb = itemb;
    }

    public void ItemList(String itema,String itemb,int scorea,int scoreb){
        this.itema = itema;
        this.itemb = itemb;
        this.scorea = scorea;
        this.scoreb = scoreb;
    }

    public String getItema() {
        return itema;
    }

    public void setItema(String itema) {
        this.itema = itema;
    }

    public String getItemb() {
        return itemb;
    }

    public void setItemb(String itemb) {
        this.itemb = itemb;
    }

    public int getScorea() {
        return scorea;
    }

    public void setScorea(int scorea) {
        this.scorea = scorea;
    }

    public int getScoreb() {
        return scoreb;
    }

    public void setScoreb(int scoreb) {
        this.scoreb = scoreb;
    }
}
