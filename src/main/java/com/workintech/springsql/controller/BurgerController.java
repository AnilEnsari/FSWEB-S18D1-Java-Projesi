package com.workintech.springsql.controller;

import com.workintech.springsql.dao.BurgerDao;
import com.workintech.springsql.entity.Burger;
import com.workintech.springsql.entity.Enums.BreadType;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/burger")
public class BurgerController {
    private BurgerDao burgerDao;

    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

    @PostMapping("/")
    public Burger save (@RequestBody Burger burger){

        return burgerDao.save(burger);
    }
    @GetMapping("/")
    public List<Burger> findAll (){

        return burgerDao.findAll();
    }
    @GetMapping("/{id}")
    public Burger findById (@PathVariable int id){

       return burgerDao.findById(id);
    }
    @PutMapping("/")
    public Burger update( @RequestBody Burger burger){

       return burgerDao.update(burger);

    }
    @DeleteMapping("/{id}")
    public Burger remove (@PathVariable int id){
       return burgerDao.remove(id);

    }
    @GetMapping("/findByContent/{content}")
    public List <Burger> findByContent(@PathVariable String content){

        return burgerDao.findByContent(content);

    }

    @GetMapping("/findByPrice/{price}")
    public List <Burger> findByPrice (@PathVariable Double price){
        return burgerDao.findByPrice(price);
    }
    @GetMapping("/findByBreadType/{breadType}")
    public List <Burger> findByBreadType(@PathVariable String breadType){
BreadType breadTypeEnum = BreadType.valueOf(breadType);
        return burgerDao.findByBreadType(breadTypeEnum);
    }
}
