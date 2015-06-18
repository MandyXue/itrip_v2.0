package dao;

import entity.FoodEntity;

import java.util.List;

/**
 * Created by AngelYang on 2015/6/4.
 */
public interface FoodDao {
    List<FoodEntity> findProvinceFoods(String province);

    FoodEntity findFoodDetail(String foodName);


    void create(FoodEntity foodEntity);

    void remove(FoodEntity foodEntity);

    void update(FoodEntity foodEntity);
}
