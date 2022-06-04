package DesignPattern.ChainOfResponsibility;

public class AddNumber implements IChain{

    private IChain nextChain;
    @Override
    public void setNextChain(IChain nextChain) {
           this.nextChain=nextChain;
    }

    @Override
    public int calculator(Number a) {
        if("add".equals(a.getCalculatorWanted())){
            return a.getNumber1()+a.getNumber2();
        }
        return nextChain.calculator(a);
    }
    
}
