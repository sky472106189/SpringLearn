package com.myself.staticfactory;

public class CarFactory {
    //静态方法，返回Car对象
    public static Car getCar(){
        return new Car();
    }
}
