package application.entity;

import java.util.Objects;

public class Supplier {

    private int supplierId;
    private String supplierName;

    public Supplier() {
    }

    public Supplier(int supplierId, String supplierName) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
    }

    public int getSupplierId() {
        return this.supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return this.supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Supplier supplierId(int supplierId) {
        this.supplierId = supplierId;
        return this;
    }

    public Supplier supplierName(String supplierName) {
        this.supplierName = supplierName;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Supplier)) {
            return false;
        }
        Supplier supplier = (Supplier) o;
        return supplierId == supplier.supplierId && Objects.equals(supplierName, supplier.supplierName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierId, supplierName);
    }

    @Override
    public String toString() {
        return "{" +
            " supplierId='" + getSupplierId() + "'" +
            ", supplierName='" + getSupplierName() + "'" +
            "}";
    }

}
    