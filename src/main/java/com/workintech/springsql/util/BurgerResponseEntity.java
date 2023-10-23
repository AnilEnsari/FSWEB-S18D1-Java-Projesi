package com.workintech.springsql.util;

import com.workintech.springsql.dto.BurgerResponse;
import com.workintech.springsql.entity.Burger;

import java.util.ArrayList;
import java.util.List;

public class BurgerResponseEntity {

    public static List<BurgerResponse> burgerToResponse(List <Burger> burgers){
        List<BurgerResponse> responses = new ArrayList<>();
        for(Burger burger : burgers){
            responses.add(new BurgerResponse(burger.getName(),burger.getPrice()));
        }
        return responses;

    }
}
