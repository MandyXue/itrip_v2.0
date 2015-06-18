package service;

import dao.PersonalDao;
import entity.SpotEntity;
import entity.UserFoodEntity;
import entity.UserSpotEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2015/6/10.
 */
@Transactional
@Service
public class PersonalService {
    @Autowired
    PersonalDao personalDao;

    public List<UserFoodEntity> getThumbFood(String username){
        return personalDao.findThumbFood(username);
    }

    public List<UserSpotEntity> getThumbSpot(String username,String type){
        return personalDao.findThumbSpot(username,type);
    }
}
