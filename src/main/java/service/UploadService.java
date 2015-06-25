package service;

import dao.UploadDao;
import entity.FoodEntity;
import entity.SpotEntity;
import entity.UploadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by AngelYang on 2015/6/12.
 */
@Transactional
@Service
public class UploadService {
    @Autowired
    UploadDao uploadDao;

    public List<UploadEntity> findAllUploads(){
        return uploadDao.findAllUploads();
    }

    public UploadEntity findUpload(String userName,String spotfood){
        return uploadDao.findUpload(userName,spotfood);
    }

    public void updateValid(UploadEntity uploadEntity,int valid,String type){
        UploadEntity uploadEntity1=uploadEntity;
        if(type.equals("pictures")){
            uploadEntity1.setPvalid(valid);
        }else{
            uploadEntity1.setDvalid(valid);
        }
        uploadDao.update(uploadEntity1);
    }

    public List<UploadEntity> getValid(String spotfood){
        return uploadDao.getValid(spotfood);
    }

    public String getCheck(String username,String spotfood){
        return uploadDao.check(username,spotfood);
    }

    public List<UploadEntity> getpersonal(String username){
        return uploadDao.personal(username);
    }
}
