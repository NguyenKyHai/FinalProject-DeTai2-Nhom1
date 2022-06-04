
package DesignPattern.ChainOfResponsibility;

public class SubNumber implements IChain{

   private IChain nextChain;
    @Override
    public void setNextChain(IChain nextChain) {
           this.nextChain=nextChain;
    }

    @Override
    public int calculator(Number a) {
        if("sub".equals(a.getCalculatorWanted())){
            return a.getNumber1()-a.getNumber2();
        }
        return -11111;
    }
}
