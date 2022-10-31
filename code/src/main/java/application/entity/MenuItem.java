package application.entity;

import java.util.Objects;

public class MenuItem extends Item {

    public MenuItem() {
    }

    public MenuItem(int itemId, int supplierId, String itemType, String itemName, String itemDescription, double price) {
        super(itemId, supplierId, itemType, itemName, itemDescription, price);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MenuItem)) {
            return false;
        }
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
}
