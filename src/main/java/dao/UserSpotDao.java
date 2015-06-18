package dao;

import entity.UserSpotEntity;

import java.util.List;

/**
 * Created by AngelYang on 2015/6/9.
 */
public interface UserSpotDao {
    void create(UserSpotEntity userSpotEntity);

    void remove(UserSpotEntity userSpotEntity);

    void update(UserSpotEntity userSpotEntity);

    List<UserSpotEntity> findUserSpot(String userName, String spotName, String type);
}
