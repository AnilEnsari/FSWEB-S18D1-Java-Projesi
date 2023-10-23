package com.workintech.springsql.dao;

import com.workintech.springsql.entity.Burger;
import com.workintech.springsql.entity.Enums.BreadType;
import com.workintech.springsql.exceptions.BurgerException;

import java.util.List;

public interface BurgerDao {

Burger save (Burger burger);
List<Burger> findAll ();
Burger findById (int id) ;
List<Burger> findByPrice (double price);
List<Burger> findByBreadType (BreadType breadType);
List<Burger>  findByContent (String content);
Burger update (Burger burger);
Burger remove  (int id) ;
}
