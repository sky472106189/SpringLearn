package com.myself.proxy;

/*
    生产厂家
*/
public class Producer implements IProducer  {

    //销售
    public void saleProduct(double money){
        System.out.println("销售产品，并拿到钱"+money);
    }

    //售后
    public void afterService(double moeny){
        System.out.println("售后服务，并拿到钱"+moeny);
    }
}
