package service;

import dao.UserFoodDao;
import entity.UserFoodEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by AngelYang on 2015/6/5.
 */
@Transactional
@Service
public class UserFoodService {
    @Autowired
    UserFoodDao userFoodDao;

    public void addUserFood(String userName, String foodName) {
        java.util.Date curDate = new java.util.Date();
        java.sql.Date date = new java.sql.Date(curDate.getTime());
        UserFoodEntity userFoodEntity = new UserFoodEntity(userName, foodName, date);

        userFoodDao.create(userFoodEntity);
    }

    public boolean findUserFood(String userName, String foodName) {
        List<UserFoodEntity> userFoodEntities = userFoodDao.findUserFood(userName, foodName);
        if (userFoodEntities.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public void removeUserFood(String userName, String foodName) {
        List<UserFoodEntity> userFoodEntities = userFoodDao.findUserFood(userName, foodName);
        UserFoodEntity userFood = userFoodEntities.get(0);
        userFoodDao.remove(userFood);
    }

}
