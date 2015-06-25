package controller;

import entity.FoodEntity;
import entity.SpotEntity;
import entity.UploadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.FoodService;
import service.SpotService;
import service.UploadService;

/**
 * Created by AngelYang on 2015/6/12.
 */
@Controller
//@RequestMapping(value = "/valid")
public class ValidController {
    @Autowired
    UploadService uploadService;
    @Autowired
    FoodService foodService;
    @Autowired
    SpotService spotService;

    @RequestMapping(value = "/valid",method = RequestMethod.GET)
    public String validate(@RequestParam(value = "userName",required = true)String userName,
                           @RequestParam(value = "spotfood",required = true)String spotfood,
                           @RequestParam(value = "type",required = true)String type,Model model){
        int valid;
        UploadEntity uploadEntity=uploadService.findUpload(userName,spotfood);

        if(type.equals("pictures")){
            valid=uploadEntity.getPvalid();
            valid=Math.abs(valid - 1);  //0->1 1->0
            uploadService.updateValid(uploadEntity, valid, type);
        }else{
            String description=uploadEntity.getDescription();
            valid=uploadEntity.getDvalid();
            valid=Math.abs(valid-1);
            uploadService.updateValid(uploadEntity, valid, type);

            //Update Food Table and Spot Table
            FoodEntity foodEntity=foodService.getFoodDetail(spotfood);
            if(foodEntity!=null){
                foodService.updateDsp(foodEntity,description);
            }else {
                SpotEntity spotEntity=spotService.getSpotDetail(spotfood);
                spotService.updateDsp(spotEntity,description);
            }
        }

        model.addAttribute("valid",valid);
        return "valid";
    }
}
