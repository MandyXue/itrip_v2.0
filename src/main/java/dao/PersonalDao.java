package dao;

import entity.UserFoodEntity;
import entity.UserSpotEntity;

import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2015/6/10.
 */
public interface PersonalDao {
    List<UserFoodEntity> findThumbFood(String username);
    List<UserSpotEntity> findThumbSpot(String username, String type);
//    List<UserSpotEntity> findThumbSpot(String username);
    Set findThumbSpot(String username);
}
