package controller;

import dao.SpotDao;
import entity.FoodEntity;
import entity.SpotEntity;
import javafx.scene.effect.Light;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.FoodService;
import service.SpotService;

import java.util.List;

/**
 * Created by AngelYang on 2015/6/4.
 */
@Controller
public class SpotDetailController {
    @Autowired
    private FoodService foodService;
    @Autowired
    private SpotService spotService;


    @RequestMapping(value = "/spot", method = RequestMethod.GET)
    public String showSpot(Model model,
                           @RequestParam(value = "province", required = true) String province,
                           @RequestParam(value = "spotName", required = true) String spotName) {
        SpotEntity spotDetail = spotService.getSpotDetail(spotName);
        model.addAttribute("spotDetail", spotDetail);

        List<FoodEntity> provinceFoods = foodService.getProvinceFood(province);
        model.addAttribute("foods", provinceFoods);

        List<SpotEntity> provinceSpots = spotService.getProvinceSpots(province);
        model.addAttribute("spots", provinceSpots);

        String type = "spot";
        model.addAttribute("type", type);

        return "detail";
    }
}
