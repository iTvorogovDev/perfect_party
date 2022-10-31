package application.entity;

import java.util.Objects;

public class Item{
    private int itemId, supplierId;
    private String itemType, itemName, itemDescription;
    private double price;

    public Item() {
    }

    public Item(int supplierId, String itemType, String itemName, String itemDescription, double price) {
        this.supplierId = supplierId;
        this.itemType = itemType;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.price = price;
    }

    public Item(int itemId, int supplierId, String itemType, String itemName, String itemDescription, double price) {
        this.itemId = itemId;
        this.supplierId = supplierId;
        this.itemType = itemType;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.price = price;
    }

    public int getItemId() {
        return this.itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getSupplierId() {
        return this.supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getItemType() {
        return this.itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return this.itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Item itemId(int itemId) {
        this.itemId = itemId;
        return this;
    }

    public Item supplierId(int supplierId) {
        this.supplierId = supplierId;
        return this;
    }

    public Item itemType(String itemType) {
        this.itemType = itemType;
        return this;
    }

    public Item itemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public Item itemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
        return this;
    }

    public Item price(double price) {
        this.price = price;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Item)) {
            return false;
        }
        Item item = (Item) o;
        return itemId == item.itemId && supplierId == item.supplierId && Objects.equals(itemType, item.itemType) && Objects.equals(itemName, item.itemName) && Objects.equals(itemDescription, item.itemDescription) && price == item.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId, supplierId, itemType, itemName, itemDescription, price);
    }

    @Override
    public String toString() {
        return "{" +
            " itemId='" + getItemId() + "'" +
            ", supplierId='" + getSupplierId() + "'" +
            ", itemType='" + getItemType() + "'" +
            ", itemName='" + getItemName() + "'" +
            ", itemDescription='" + getItemDescription() + "'" +
            ", price='" + getPrice() + "'" +
            "}";
    }

}
