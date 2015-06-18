package dao;

import entity.UsertableEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;

/**
 * Created by Administrator on 2015/6/6.
 */
@Repository
public class RegisterDaoImpl implements RegisterDao {
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

    public String checkregister(String username, String password, String email) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery c = cb.createQuery(UsertableEntity.class);
        Root<UsertableEntity> user = c.from(UsertableEntity.class);
        Path<String> un = user.get("username");
        Path<String> el = user.get("email");
        Predicate p1 = cb.equal(un, username);
        Predicate p2 = cb.equal(el, email);
        c.where(p1);
        TypedQuery<UsertableEntity> tq1 = em.createQuery(c);
        if (!(tq1.getResultList()).isEmpty())
            return "fail1";
        c.where(p2);
        TypedQuery<UsertableEntity> tq2 = em.createQuery(c);
        if (!(tq2.getResultList()).isEmpty())
            return "fail2";
        else {
            UsertableEntity newuser = new UsertableEntity();
            newuser.setUsername(username);
            newuser.setPassword(password);
            newuser.setEmail(email);
            create(newuser);
            return username;
        }
    }
}
