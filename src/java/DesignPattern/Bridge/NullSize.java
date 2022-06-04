package DesignPattern.Bridge;

public class NullSize implements ISize{

    @Override
    public String getSize() {
        return "Size khong hop le. Cac size hop le la: Small, Medium, Large";
    }
    
}
