package Model;

public class Order {

    private int cartid;
    private String buydate;
    private String hoten;
    private String sdt;
    private String diachi;
    private int status;
    private int itemid;
    private String productname;
    private int price;
    private int quantity;
    private String size;
    private String topping;
    private String image;

    public Order() {
    }

    public Order(int cartid, String buydate, String hoten, String sdt, String diachi, int status, int itemid, String productname, int price, int quantity, String size, String topping, String image) {
        this.cartid = cartid;
        this.buydate = buydate;
        this.hoten = hoten;
        this.sdt = sdt;
        this.diachi = diachi;
        this.status = status;
        this.itemid = itemid;
        this.productname = productname;
        this.price = price;
        this.quantity = quantity;
        this.size = size;
        this.topping = topping;
        this.image = image;
    }

    public int getCartid() {
        return cartid;
    }

    public void setCartid(int cartid) {
        this.cartid = cartid;
    }

    public String getBuydate() {
        return buydate;
    }

    public void setBuydate(String buydate) {
        this.buydate = buydate;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
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

   
}
