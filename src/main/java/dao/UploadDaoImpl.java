package dao;

import entity.FoodEntity;
import entity.SpotEntity;
import entity.UploadEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by AngelYang on 2015/6/12.
 */
@Repository
public class UploadDaoImpl implements UploadDao {
    private EntityManager em;
    @PersistenceContext
    void setEntityManager(EntityManager entityManager){this.em=entityManager;}

    public void create(UploadEntity uploadEntity){
        em.persist(uploadEntity);
    }
    public void remove(UploadEntity uploadEntity){
        em.remove(uploadEntity);
    }
    public void update(UploadEntity uploadEntity){
        em.merge(uploadEntity);
    }

    @Override
    public List<UploadEntity> findAllUploads() {
        CriteriaBuilder cb=em.getCriteriaBuilder();
        CriteriaQuery c=cb.createQuery(UploadEntity.class);
        Root<UploadEntity> upload=c.from(UploadEntity.class);
        c.select(upload);
        TypedQuery<UploadEntity> tq=em.createQuery(c);
        return tq.getResultList();
    }

    @Override
    public UploadEntity findUpload(String userName, String spotfood) {
        CriteriaBuilder cb=em.getCriteriaBuilder();
        CriteriaQuery c=cb.createQuery(UploadEntity.class);
        Root<UploadEntity> upload=c.from(UploadEntity.class);
        Path<String > un=upload.get("username");
        Path<String> sf=upload.get("spotfood");
        Predicate p= cb.and(cb.equal(un,userName),cb.equal(sf,spotfood));
        c.where(p);
        TypedQuery<UploadEntity> tq=em.createQuery(c);
        List<UploadEntity> uploadEntities=tq.getResultList();
        return uploadEntities.get(0);
    }

    @Override
    public List<UploadEntity> getValid(String spotfood) {
        CriteriaBuilder cb=em.getCriteriaBuilder();
        CriteriaQuery c=cb.createQuery(UploadEntity.class);
        Root<UploadEntity> upload=c.from(UploadEntity.class);
        Path<String> v=upload.get("pvalid"); //????int String
        Path<String> sf=upload.get("spotfood");
        Predicate p= cb.and(cb.equal(sf,spotfood),cb.equal(v,"1"));
        c.where(p);
        TypedQuery<UploadEntity> tq=em.createQuery(c);
        return tq.getResultList();
    }


}
