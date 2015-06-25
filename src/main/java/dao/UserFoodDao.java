package dao;

import entity.UserFoodEntity;

import java.util.List;

/**
 * Created by AngelYang on 2015/6/5.
 */
public interface UserFoodDao {
    void create(UserFoodEntity userFoodEntity);

    void remove(UserFoodEntity userFoodEntity);

    void update(UserFoodEntity userFoodEntity);

    List<UserFoodEntity> findUserFood(String userName, String foodName);

}
