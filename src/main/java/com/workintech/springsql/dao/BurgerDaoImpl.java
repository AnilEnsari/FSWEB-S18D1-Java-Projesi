package com.workintech.springsql.dao;

import com.workintech.springsql.entity.Burger;
import com.workintech.springsql.entity.Enums.BreadType;
import com.workintech.springsql.exceptions.BurgerException;
import com.workintech.springsql.util.BurgerValidation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BurgerDaoImpl implements BurgerDao{
    private EntityManager entityManager;

    @Autowired
    public BurgerDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
@Transactional
    @Override
    public Burger save(Burger burger) {
    BurgerValidation.isBurgerCredentialValid(burger);
        entityManager.persist(burger);
        return burger;
    }

    @Override
    public List<Burger> findAll() {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT b FROM Burger b", Burger.class);
        return query.getResultList();
    }

    @Override
    public Burger findById(int id) throws BurgerException {
        Burger burger = entityManager.find(Burger.class,id);
        if(burger == null){
            throw new BurgerException("The id is invalid. Burger is not found: "+id, HttpStatus.NOT_FOUND);
        }
        return burger;

    }

    @Override
    public List<Burger> findByPrice(double price) {
        TypedQuery<Burger> query = entityManager.createQuery("Select b FROM Burger b Where b.price > :price " +
                "ORDER BY b.price desc", Burger.class);
        query.setParameter("price",price);
        return query.getResultList();
    }

    @Override
    public List<Burger> findByBreadType(BreadType breadType) {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT b FROM Burger b WHERE b.breadType =" +
                " :breadType ORDER BY b.name asc", Burger.class);
        query.setParameter("breadType",breadType);
        return query.getResultList();
    }

    @Override
    public List<Burger> findByContent(String content) {
        TypedQuery<Burger> query = entityManager.createQuery("SELECT b FROM Burger b WHERE b.contents like " +
                "CONCAT('%', :content, '%')ORDER by b.name asc", Burger.class);
        query.setParameter("content",content);


        return query.getResultList();
    }

    @Transactional
    @Override
    public Burger update(Burger burger) {
        entityManager.merge(burger);
        return burger;
    }

    @Transactional
    @Override
    public Burger remove(int id) throws BurgerException {
        Burger  burger = findById(id);
        entityManager.remove(burger);
        return burger;
    }

}
