package Model;

import DesignPattern.TemplateMethod.SortTemplate;
import java.io.Serializable;

public class LineItem {
    int id;
    String productname;
    int price;
    int quantity;
    String size;
    int productcode;
    String topping;
    String image;
    int cartid;

    public LineItem() {
    }

    public LineItem(int id, String productname, int price, int quantity, String size, int productcode, String topping, String image, int cartid) {
        this.id = id;
        this.productname = productname;
        this.price = price;
        this.quantity = quantity;
        this.size = size;
        this.productcode = productcode;
        this.topping = topping;
        this.image = image;
        this.cartid = cartid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getProductcode() {
        return productcode;
    }

    public void setProductcode(int productcode) {
        this.productcode = productcode;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCartid() {
        return cartid;
    }

    public void setCartid(int cartid) {
        this.cartid = cartid;
    }

    @Override
    public String toString() {
        return "LineItem{" + "id=" + id + ", productname=" + productname + ", price=" + price 
                + ", quantity=" + quantity + ", size=" + size + ", productcode=" 
                + productcode + ", topping=" + topping + ", image=" + image + ", cartid=" + cartid + '}';
    }

  
       
}
