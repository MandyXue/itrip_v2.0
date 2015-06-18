package service;

import dao.FoodDao;
import entity.FoodEntity;
import entity.UserFoodEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by AngelYang on 2015/6/4.
 */
@Transactional
@Service
public class FoodService {
    @Autowired
    private FoodDao foodDao;

    public List<FoodEntity> getProvinceFood(String province) {
        return foodDao.findProvinceFoods(province);
    }

    public FoodEntity getFoodDetail(String foodName) {
        return foodDao.findFoodDetail(foodName);
    }

    public Integer addFoodThumbs(String foodName) {
        FoodEntity food = foodDao.findFoodDetail(foodName);
        FoodEntity food2 = food;
        food2.setThumbs(food.getThumbs() + 1); //update food by add 1 to Thumbs
        foodDao.update(food2);
        return food2.getThumbs();
    }

    public Integer dropFoodThumbs(String foodName) {
        FoodEntity food = foodDao.findFoodDetail(foodName);
        FoodEntity food2 = food;
        food2.setThumbs(food.getThumbs() - 1); //update food by add 1 to Thumbs
        foodDao.update(food2);
        return food2.getThumbs();
    }

    public void updateDsp(FoodEntity foodEntity,String description){
        FoodEntity foodEntity1=foodEntity;
        foodEntity1.setDescription(description);
        foodDao.update(foodEntity1);
    }
}
