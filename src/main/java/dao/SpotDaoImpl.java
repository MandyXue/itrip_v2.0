package dao;

import entity.FoodEntity;
import entity.SpotEntity;
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
public class SpotDaoImpl implements SpotDao {
    private EntityManager em;

    @PersistenceContext
    void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

    public void create(SpotEntity spotEntity) {
        em.persist(spotEntity);
    }

    public void remove(SpotEntity spotEntity) {
        em.remove(spotEntity);
    }

    public void update(SpotEntity spotEntity) {
        em.merge(spotEntity);
    }

    public SpotEntity findSpotDetail(String spotName) {
        SpotEntity spot = em.find(SpotEntity.class, spotName);
        return spot;
    }

    public List<SpotEntity> findProvinceSpots(String province) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery c = cb.createQuery(SpotEntity.class);
        Root<SpotEntity> spot = c.from(SpotEntity.class);
        Path<String> province1 = spot.get("province");
        Predicate p = cb.equal(province1, province);
//        c.where(cb.equal(spot.get(province),province));
        c.where(p);
        TypedQuery<SpotEntity> tq = em.createQuery(c);
        return tq.getResultList();
    }
}
