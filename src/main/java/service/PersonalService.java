package service;

import dao.PersonalDao;
import entity.UserFoodEntity;
import entity.UserSpotEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

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

//    public List<UserSpotEntity> getThumbSpot(String username){
//        return personalDao.findThumbSpot(username);
//    }
    public Set getThumbSpot(String username){
    return personalDao.findThumbSpot(username);
}
}
