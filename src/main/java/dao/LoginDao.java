package dao;

import entity.UsertableEntity;

/**
 * Created by Administrator on 2015/6/5.
 */
public interface LoginDao {
    String checklogin(String username, String password);


    void create(UsertableEntity usertableEntity);

    void remove(UsertableEntity usertableEntity);

    void update(UsertableEntity usertableEntity);

    UsertableEntity findUser(String userName);
}
