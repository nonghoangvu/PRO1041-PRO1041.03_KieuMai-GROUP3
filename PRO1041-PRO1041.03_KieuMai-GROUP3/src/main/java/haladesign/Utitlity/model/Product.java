package haladesign.Utitlity.model;

import java.util.Objects;
import java.util.Optional;

/**
 *
 * @author NONG HOANG VU
 */
public class Product {

    private Optional<String> pname;
    private int quantity;
    private Long priceperpeice;

    public Product(String pname, int quantity, Long priceperpeice) {
        this.pname = Optional.ofNullable(pname);
        this.quantity = quantity;
        this.priceperpeice = priceperpeice;
    }

    public Optional<String> getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = Optional.ofNullable(pname);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getPriceperpeice() {
        return priceperpeice;
    }

    public void setPriceperpeice(Long priceperpeice) {
        this.priceperpeice = priceperpeice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Product)) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(pname, product.pname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pname);
    }

    @Override
    public String toString() {
        return "{"
                + "pname=" + pname
                + ", quantity=" + quantity
                + ", priceperpeice=" + priceperpeice
                + '}';
    }
}
