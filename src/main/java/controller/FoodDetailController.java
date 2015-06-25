package controller;

import entity.FoodEntity;
import entity.SpotEntity;
import entity.UploadEntity;
import entity.UserFoodEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import service.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by AngelYang on 2015/6/4.
 */
@Controller
@SessionAttributes("userId")
public class FoodDetailController {
    @Autowired
    private FoodService foodService;
    @Autowired
    private SpotService spotService;
    @Autowired
    private UserFoodService userFoodService;
    @Autowired
    private UploadService uploadService;

    private String username;
    private String spotfood;

    @RequestMapping(value = "/food", method = RequestMethod.GET)
    public String showFood(Model model,
                           @RequestParam(value = "province", required = true) String province,
                           @RequestParam(value = "foodName", required = true) String foodName,HttpSession session) {

        username= (String) session.getAttribute("userId");
        spotfood= foodName;
        String checkup = uploadService.getCheck(username,spotfood);
        model.addAttribute("checkup",checkup);

        FoodEntity foodDetail = foodService.getFoodDetail(foodName);
        model.addAttribute("foodDetail", foodDetail);

        List<FoodEntity> provinceFoods = foodService.getProvinceFood(province);
        model.addAttribute("foods", provinceFoods);

        List<SpotEntity> provinceSpots = spotService.getProvinceSpots(province);
        model.addAttribute("spots", provinceSpots);

        String type = "food";
        model.addAttribute("type", type);

        String userName=(String)session.getAttribute("userId");
        boolean userFood=userFoodService.findUserFood(userName,foodName);
        model.addAttribute("userFood",userFood);

        //upload picture
        List<UploadEntity> validFood= uploadService.getValid(foodName);
        int validFoodNum=validFood.size();
        model.addAttribute("validFood",validFood);
        model.addAttribute("validFoodNum",validFoodNum);

        return "detail";
    }
}
