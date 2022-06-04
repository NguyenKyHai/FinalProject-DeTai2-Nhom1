package DesignPattern.Proxy;

public class RealImage implements IProxy{
    String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
    }    

    @Override
    public String getImage() {
        return fileName;
    }
   
    
}
