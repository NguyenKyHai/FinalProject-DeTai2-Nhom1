package DesignPattern.ChainOfResponsibility;

public interface IChain {
    void setNextChain(IChain nextChain);
    int calculator(Number a);
}
