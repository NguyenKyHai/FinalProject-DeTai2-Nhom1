package DesignPattern.Factory;

import DesignPattern.Bridge.Large;
import DesignPattern.Bridge.ISize;
import DesignPattern.Bridge.Medium;
import DesignPattern.Bridge.NullSize;
import DesignPattern.Bridge.Small;

public class SizeFactory {
    
        public static ISize creatSize(String name) {
            if (name == null) {
                return null;
            }
            switch (name) {
                case "Large":
                    return new Large();
                case "Medium":
                    return new Medium();
                case "Small":
                    return new Small();
                default:
                   return new NullSize();

            }
        }
}
