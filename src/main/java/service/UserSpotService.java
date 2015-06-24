package service;

import dao.UserSpotDao;
import entity.UserSpotEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by AngelYang on 2015/6/9.
 */
@Transactional
@Service
public class UserSpotService {
    @Autowired
    UserSpotDao userSpotDao;

    public void addUserSpot(String userName, String spotName, String type) {
        java.util.Date curDate = new java.util.Date();
        java.sql.Date date = new java.sql.Date(curDate.getTime());
        UserSpotEntity userSpotEntity = new UserSpotEntity(userName, spotName, date, type);
        userSpotDao.create(userSpotEntity);
    }

    public boolean findUserSpot(String userName, String spotName, String type) {
        List<UserSpotEntity> userSpotEntities = userSpotDao.findUserSpot(userName, spotName, type);
        if (userSpotEntities.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public void removeUserSpot(String userName, String spotName, String type) {
        List<UserSpotEntity> userSpotEntities = userSpotDao.findUserSpot(userName, spotName, type);
        UserSpotEntity userSpot = userSpotEntities.get(0);
        userSpotDao.remove(userSpot);
    }
}
