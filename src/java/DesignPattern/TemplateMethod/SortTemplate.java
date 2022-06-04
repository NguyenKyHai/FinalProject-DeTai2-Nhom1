package DesignPattern.TemplateMethod;

import java.util.ArrayList;
import java.util.List;

public abstract class SortTemplate<T> {
    public List<T> sort(List<T> list){
        T num1, num2;
        boolean swapHappened = true;

        while(swapHappened){
            swapHappened = false;

            for(int i = 0; i < (list.size() - 1); i++) {
                num1 =  (T) list.get(i);
                num2 =  (T) list.get(i+1);

                if (compare(num1, num2)) {
                    swap(i, list, num1, num2);
                    swapHappened = true;
                }
            }
        }
        return list;
    }

    public void swap(int index, List list, T first, T second){
        list.set(index, second);
        list.set(index + 1, first);
    }

   protected abstract boolean compare(T num1, T num2);
}
