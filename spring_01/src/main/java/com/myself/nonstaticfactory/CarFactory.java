package com.myself.nonstaticfactory;

public class CarFactory {

    //非静态方法，返回Car对象
    public Car getCar(){
        return new Car();
    }
}
