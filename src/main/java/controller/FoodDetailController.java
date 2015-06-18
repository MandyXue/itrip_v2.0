package controller;

import entity.FoodEntity;
import entity.SpotEntity;
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
public class FoodDetailController {
    @Autowired
    private FoodService foodService;
    @Autowired
    private SpotService spotService;

    @RequestMapping(value = "/food", method = RequestMethod.GET)
    public String showFood(Model model,
                           @RequestParam(value = "province", required = true) String province,
                           @RequestParam(value = "foodName", required = true) String foodName) {
        FoodEntity foodDetail = foodService.getFoodDetail(foodName);
        model.addAttribute("foodDetail", foodDetail);

        List<FoodEntity> provinceFoods = foodService.getProvinceFood(province);
        model.addAttribute("foods", provinceFoods);

        List<SpotEntity> provinceSpots = spotService.getProvinceSpots(province);
        model.addAttribute("spots", provinceSpots);

        String type = "food";
        model.addAttribute("type", type);

        return "detail";
    }
}
