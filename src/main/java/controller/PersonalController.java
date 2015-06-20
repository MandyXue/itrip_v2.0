package controller;

import entity.UserFoodEntity;
import entity.UserSpotEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.PersonalService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2015/6/10.
 */
@Controller
public class PersonalController {
    @Autowired
    private PersonalService personalService;

//    @RequestMapping(value = "/personal",method = RequestMethod.GET)
//    public String showPersonal
//            (Model model,HttpSession session,
//             @RequestParam(value = "type",required = true)String type,
//             @RequestParam(value="s_or_f",required = true)String s_or_f)
//    {
//        String username= (String) session.getAttribute("userId");
//        if (s_or_f.equals("food")){
//        List<UserFoodEntity> thumbFood=personalService.getThumbFood(username);
//        model.addAttribute("personalFood",thumbFood);
//            System.out.println(s_or_f+"1");
//            return "personal_food";
//        }
//        else {
//        List<UserSpotEntity> thumbSpot=personalService.getThumbSpot(username,type);
//        model.addAttribute("personalSpot",thumbSpot);
//            System.out.println(s_or_f+"2");
//        return "personal_spot";}
//    }
    @RequestMapping(value = "/personal",method = RequestMethod.GET)
    public String showPersonal(
            Model model,
            HttpSession session,
            @RequestParam(value = "s_or_f", required = true)String s_or_f,
            @RequestParam(value = "type", required = false)String type
    ) {
        String username = (String) session.getAttribute("userId");
        if (s_or_f.equals("food")) {
            List<UserFoodEntity> thumbFood = personalService.getThumbFood(username);
            model.addAttribute("personalFood", thumbFood);
            return "personal_food";
        }else if (s_or_f.equals("spot")){
            List<UserSpotEntity> thumbSpot=personalService.getThumbSpot(username);
            model.addAttribute("personalSpot",thumbSpot);
            return "personal_spot";
        }else{
            model.addAttribute("personal_wrong","wrong");
            return "home";
        }
    }
}
