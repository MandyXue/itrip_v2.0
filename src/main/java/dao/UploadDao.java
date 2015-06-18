package dao;

import entity.FoodEntity;
import entity.SpotEntity;
import entity.UploadEntity;

import java.util.List;

/**
 * Created by AngelYang on 2015/6/12.
 */
public interface UploadDao {
    void create(UploadEntity uploadEntity);
    void remove(UploadEntity uploadEntity);
    void update(UploadEntity uploadEntity);

    List<UploadEntity> findAllUploads();
    UploadEntity findUpload(String userName, String spotfood);
    List<UploadEntity> getValid(String spotfood);

}
