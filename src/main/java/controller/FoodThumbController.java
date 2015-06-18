package controller;

import entity.FoodEntity;
import org.eclipse.persistence.sessions.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.FoodService;
import service.UserFoodService;

import javax.servlet.http.HttpSession;

/**
 * Created by AngelYang on 2015/6/5.
 */
@Controller
public class FoodThumbController {
    @Autowired
    private FoodService foodService;
    @Autowired
    private UserFoodService userFoodService;

    @RequestMapping(value = "/foodThumbs", method = RequestMethod.GET)
    public
    @ResponseBody
    String showFoodThumbs(
            @RequestParam(value = "foodName", required = true) String foodName, HttpSession session) {
        Integer foodThumbs;
        String userName = (String) session.getAttribute("userId");

        //已经存在点赞记录,删除
        if (userFoodService.findUserFood(userName, foodName)) {
            userFoodService.removeUserFood(userName, foodName);
            foodThumbs = foodService.dropFoodThumbs(foodName);
        }

        //新增点赞记录
        else if (userName.equals(null)) {
            foodThumbs = foodService.addFoodThumbs(foodName);
        } else {
            foodThumbs = foodService.addFoodThumbs(foodName);
            userFoodService.addUserFood(userName, foodName);
        }

        return Integer.toString(foodThumbs);
    }
}
