package DesignPattern.Proxy;

public class ProxyImage implements IProxy{
    String fileName;
    RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }
    

    @Override
    public String getImage() {
        if(realImage==null){
            realImage=new RealImage(fileName);
        }
        return realImage.getImage();
    }
    
}
