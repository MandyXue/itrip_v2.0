package dao;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import entity.UsertableEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.lang.reflect.Type;


/**
 * Created by Administrator on 2015/6/5.
 */
@Repository
public class LoginDaoImpl implements LoginDao {
    private EntityManager em;

    @PersistenceContext
    void setEntityManager(EntityManager entityManager) {
        this.em = entityManager;
    }

    public void create(UsertableEntity usertableEntity) {
        em.persist(usertableEntity);
    }

    public void remove(UsertableEntity usertableEntity) {
        em.remove(usertableEntity);
    }

    public void update(UsertableEntity usertableEntity) {
        em.merge(usertableEntity);
    }

    public String checklogin(String username, String password) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery c = cb.createQuery(UsertableEntity.class);
        Root<UsertableEntity> user = c.from(UsertableEntity.class);
        Path<String> un = user.get("username");
        Path<String> pw = user.get("password");
//        check username first
        Predicate p_name = cb.and(cb.equal(un,username));
        c.where(p_name);
        TypedQuery<UsertableEntity> tq_name = em.createQuery(c);
        if (tq_name.getResultList().isEmpty()){
            return "userWrong";
        }else{
            Predicate p = cb.and(cb.equal(un, username), cb.equal(pw, password));
            c.where(p);
            TypedQuery<UsertableEntity> tq = em.createQuery(c);
            if (!(tq.getResultList()).isEmpty())
                return "success";
            else
                return "pwdWrong";
        }
    }
}
