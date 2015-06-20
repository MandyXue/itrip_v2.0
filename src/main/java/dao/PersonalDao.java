package dao;

import entity.UserFoodEntity;
import entity.UserSpotEntity;

import java.util.List;

/**
 * Created by Administrator on 2015/6/10.
 */
public interface PersonalDao {
    List<UserFoodEntity> findThumbFood(String username);
    List<UserSpotEntity> findThumbSpot(String username, String type);
    List<UserSpotEntity> findThumbSpot(String username);
}
