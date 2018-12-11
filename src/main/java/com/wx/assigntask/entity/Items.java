package com.wx.assigntask.entity;

/**
 * @Author: wx
 * @Date: 2018/12/10 15:25
 * @Version 1.0
 */
public class Items {
    /**
     * 存放item_name以及对应的describe
     */
    private int itemId;
    private String itemName;
    private String itemDes;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDes() {
        return itemDes;
    }

    public void setItemDes(String itemDes) {
        this.itemDes = itemDes;
    }

    @Override
    public String toString() {
        return "Items{" +
                "itemId=" + itemId +
                ", itemName='" + itemName + '\'' +
                ", itemDes='" + itemDes + '\'' +
                '}';
    }
}
