package com.workintech.springsql.util;

import com.workintech.springsql.entity.Burger;
import com.workintech.springsql.exceptions.BurgerException;
import org.springframework.http.HttpStatus;

public class BurgerValidation {

    public static void isBurgerCredentialValid (Burger burger){

        if(burger.getName()==null||burger.getPrice()<=0){

            throw new BurgerException("Please enter a valid burger "+ burger, HttpStatus.BAD_REQUEST);
        }
    }
}
