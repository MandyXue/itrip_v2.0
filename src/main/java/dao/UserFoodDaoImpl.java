package dao;

import entity.UserFoodEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

import java.util.List;

/**
 * Created by AngelYang on 2015/6/5.
 */
@Repository
public class UserFoodDaoImpl implements UserFoodDao {
    private EntityManager em;

    @PersistenceContext
    void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

    public void create(UserFoodEntity userFoodEntity) {
        em.persist(userFoodEntity);
    }

    public void remove(UserFoodEntity userFoodEntity) {
        em.remove(userFoodEntity);
    }

    public void update(UserFoodEntity userFoodEntity) {
        em.merge(userFoodEntity);
    }

    public List<UserFoodEntity> findUserFood(String userName, String foodName) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery c = cb.createQuery(UserFoodEntity.class);
        Root<UserFoodEntity> userFood = c.from(UserFoodEntity.class);
        Path<String> un = userFood.get("username");
        Path<String> fn = userFood.get("foodname");
        Predicate p = cb.and(cb.equal(un, userName), cb.equal(fn, foodName));
        c.where(p);
        TypedQuery<UserFoodEntity> tq = em.createQuery(c);
        return tq.getResultList();
    }


}
