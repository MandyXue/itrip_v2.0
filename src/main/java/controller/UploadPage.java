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

/**
 * Created by AngelYang on 2015/6/12.
 */
@Controller
public class UploadPage {
    @Autowired
    FoodService foodService;
    @Autowired
    SpotService spotService;

    @RequestMapping(value = "/uploadPage",method = RequestMethod.GET)
    public String uploadPage(@RequestParam(value = "spotfood",required = true)String spotfood,
                             @RequestParam(value = "type",required = true)String type,Model model){

        String description;
        if(type.equals("spot")){
            SpotEntity spotEntity=spotService.getSpotDetail(spotfood);
            description=spotEntity.getDescription();
        }else{
            FoodEntity foodEntity=foodService.getFoodDetail(spotfood);
            description=foodEntity.getDescription();
        }

        model.addAttribute("type",type);
        model.addAttribute("spotfood",spotfood);
        model.addAttribute("description",description);
        return "upload";
    }
}
