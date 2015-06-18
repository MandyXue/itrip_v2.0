package dao;

import entity.UserSpotEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by AngelYang on 2015/6/9.
 */
@Repository
public class UserSpotDaoDaoImpl implements UserSpotDao {
    private EntityManager em;

    @PersistenceContext
    void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

    public void create(UserSpotEntity userSpotEntity) {
        em.persist(userSpotEntity);
    }

    public void remove(UserSpotEntity userSpotEntity) {
        em.remove(userSpotEntity);
    }

    public void update(UserSpotEntity userSpotEntity) {
        em.merge(userSpotEntity);
    }

    @Override
    public List<UserSpotEntity> findUserSpot(String userName, String spotName, String type) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery c = cb.createQuery(UserSpotEntity.class);
        Root<UserSpotEntity> userSpot = c.from(UserSpotEntity.class);
        Path<String> un = userSpot.get("username");
        Path<String> sn = userSpot.get("spotname");
        Path<String> t = userSpot.get("type");
        Predicate p = cb.and(cb.equal(un, userName), cb.equal(sn, spotName), cb.equal(t, type));
        c.where(p);
        TypedQuery<UserSpotEntity> tq = em.createQuery(c);
        return tq.getResultList();
    }
}
