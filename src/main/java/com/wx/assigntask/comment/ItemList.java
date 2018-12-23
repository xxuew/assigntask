package com.wx.assigntask.comment;

public class ItemList {
    public String itema,itemb;
    public int scorea,scoreb;
    public String desa,desb;
    public String inputname,inputdes;
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

    public void ItemList(String inputname,String inputdes,String itema,String itemb,int scorea,int scoreb,String desa,String desb){
        this.itema = itema;
        this.itemb = itemb;
        this.scorea = scorea;
        this.scoreb = scoreb;
        this.desa = desa;
        this.desb = desb;
        this.inputname = inputname;
        this.inputdes = inputdes;
    }

    public String getDesa() {
        return desa;
    }

    public void setDesa(String desa) {
        this.desa = desa;
    }

    public String getDesb() {
        return desb;
    }

    public void setDesb(String desb) {
        this.desb = desb;
    }

    public String getInputname() {
        return inputname;
    }

    public void setInputname(String inputname) {
        this.inputname = inputname;
    }

    public String getInputdes() {
        return inputdes;
    }

    public void setInputdes(String inputdes) {
        this.inputdes = inputdes;
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
