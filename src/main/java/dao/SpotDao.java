package dao;

import entity.SpotEntity;

import java.util.List;

/**
 * Created by AngelYang on 2015/6/4.
 */
public interface SpotDao {
    List<SpotEntity> findProvinceSpots(String province);

    SpotEntity findSpotDetail(String spotName);

    void create(SpotEntity spotEntity);

    void remove(SpotEntity spotEntity);

    void update(SpotEntity spotEntity);

}
