package dao;

import entity.FoodEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by AngelYang on 2015/6/4.
 */
@Repository
public class FoodDaoImpl implements FoodDao {
    private EntityManager em;

    @PersistenceContext
    void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

    public void create(FoodEntity foodEntity) {
        em.persist(foodEntity);
    }

    public void remove(FoodEntity foodEntity) {
        em.remove(foodEntity);
    }

    public void update(FoodEntity foodEntity) {
        em.merge(foodEntity);
    }

    public FoodEntity findFoodDetail(String foodName) {
        return em.find(FoodEntity.class, foodName);
    }

    public List<FoodEntity> findProvinceFoods(String province) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery c = cb.createQuery(FoodEntity.class);
        Root<FoodEntity> food = c.from(FoodEntity.class);
//        c.where(cb.equal(food.get(province),province));
        Path<String> province1 = food.get("province");
        Predicate p = cb.equal(province1, province);
        c.where(p);
//        c.select(food);
        TypedQuery<FoodEntity> tq = em.createQuery(c);
        return tq.getResultList();
    }
}
