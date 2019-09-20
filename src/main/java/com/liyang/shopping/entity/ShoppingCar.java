package com.liyang.shopping.entity;
/*
 * Project name:Book
 * Author:LiYang
 * Date:2019/7/18:9:32
 */

import java.util.Map;

public class ShoppingCar {
    private static Map<String,Object> shoppingCar;

    public static Map<String, Object> getShoppingCar() {
        return shoppingCar;
    }

    public static void setShoppingCar(Map<String, Object> shoppingCar) {
        ShoppingCar.shoppingCar = shoppingCar;
    }

}
