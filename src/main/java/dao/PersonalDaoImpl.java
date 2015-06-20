package dao;

import entity.UserFoodEntity;
import entity.UserSpotEntity;
import entity.UsertableEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by Administrator on 2015/6/10.
 */
@Repository
public class PersonalDaoImpl implements PersonalDao {
    private EntityManager em;
    @PersistenceContext
    void setEntityManager(EntityManager entityManager){this.em=entityManager;}
    public List<UserFoodEntity> findThumbFood(String username){
        CriteriaBuilder cb=em.getCriteriaBuilder();
        CriteriaQuery c=cb.createQuery(UserFoodEntity.class);
        Root<UserFoodEntity> user=c.from(UserFoodEntity.class);
        Path<String> un = user.get("username");
        Predicate p=cb.equal(un,username);
        c.where(p);
        TypedQuery<UserFoodEntity> tq=em.createQuery(c);
        return tq.getResultList();
    }
    public List<UserSpotEntity> findThumbSpot(String username,String type){
        CriteriaBuilder cb=em.getCriteriaBuilder();
        CriteriaQuery c=cb.createQuery(UserSpotEntity.class);
        Root<UserSpotEntity> user=c.from(UserSpotEntity.class);
        Path<String> un = user.get("username");
        Path<String> ty = user.get("type");
        Predicate p=cb.and(cb.equal(un,username),cb.equal(ty,type));
        c.where(p);
        TypedQuery<UserSpotEntity> tq=em.createQuery(c);
        return tq.getResultList();
    }
    public List<UserSpotEntity> findThumbSpot(String username){
        CriteriaBuilder cb=em.getCriteriaBuilder();
        CriteriaQuery c=cb.createQuery(UserSpotEntity.class);
        Root<UserSpotEntity> user=c.from(UserSpotEntity.class);
        Path<String> un = user.get("username");
        Predicate p=cb.and(cb.equal(un,username));
        c.where(p);
        TypedQuery<UserSpotEntity> tq=em.createQuery(c);
        return tq.getResultList();
    }
}
