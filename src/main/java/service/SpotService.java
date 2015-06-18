package service;

import dao.SpotDao;
import entity.SpotEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by AngelYang on 2015/6/4.
 */
@Transactional
@Service
public class SpotService {
    @Autowired
    private SpotDao spotDao;

    public List<SpotEntity> getProvinceSpots(String province) {
        return spotDao.findProvinceSpots(province);
    }

    public SpotEntity getSpotDetail(String spotName) {
        return spotDao.findSpotDetail(spotName);
    }

    public Integer addSpotThumbs(String spotName, String type) {
        int t = Integer.parseInt(type);
        int spotThumbs = 0;
        SpotEntity spot = spotDao.findSpotDetail(spotName);
        SpotEntity spot2 = spot;
        switch (t) {
            case 1:
                spotThumbs = spot.getPackageThumbs() + 1;
                spot2.setPackageThumbs(spotThumbs);
                break;
            case 2:
                spotThumbs = spot.getCoupleThumbs() + 1;
                spot2.setCoupleThumbs(spotThumbs);
                break;
            case 3:
                spotThumbs = spot.getFamilyThumbs() + 1;
                spot2.setFamilyThumbs(spotThumbs);
                break;
            default:
                break;
        }
        spotDao.update(spot2);
        return spotThumbs;
    }

    public Integer dropSpotThumbs(String spotName, String type) {
        int t = Integer.parseInt(type);
        int spotThumbs = 0;
        SpotEntity spot = spotDao.findSpotDetail(spotName);
        SpotEntity spot2 = spot;
        switch (t) {
            case 1:
                spotThumbs = spot.getPackageThumbs() - 1;
                spot2.setPackageThumbs(spotThumbs);
                break;
            case 2:
                spotThumbs = spot.getCoupleThumbs() - 1;
                spot2.setCoupleThumbs(spotThumbs);
                break;
            case 3:
                spotThumbs = spot.getFamilyThumbs() - 1;
                spot2.setFamilyThumbs(spotThumbs);
                break;
            default:
                break;
        }
        spotDao.update(spot2);
        return spotThumbs;
    }
}
