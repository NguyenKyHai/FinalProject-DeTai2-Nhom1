package Model;

import java.io.Serializable;
import java.sql.Date;

public class Cart implements Serializable{
    private int id;
    private String buydate;
    private String hoten;
    private String sdt;
    private String diachi;
    private int status;

    public Cart() {
    }

    public Cart(int id, String buydate, String hoten, String sdt, String diachi, int status) {
        this.id = id;
        this.buydate = buydate;
        this.hoten = hoten;
        this.sdt = sdt;
        this.diachi = diachi;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Cart{" + "id=" + id + ", buydate=" + buydate + ", hoten=" + hoten + ", sdt=" + sdt + 
                ", diachi=" + diachi + ", status=" + status + '}';
    }

    
}
