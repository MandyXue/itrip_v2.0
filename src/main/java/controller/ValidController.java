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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    @RequestMapping(value = "/valid", method = RequestMethod.GET)
    public void validate(HttpServletResponse response ,HttpServletRequest request) throws IOException{
        String userName = request.getParameter("username");
        String spotfood = request.getParameter("spotfood");
        String type = request.getParameter("type");
        String yorn = request.getParameter("y_or_n");
        int valid;
        UploadEntity uploadEntity=uploadService.findUpload(userName,spotfood);

        if(type.equals("pictures")){
            valid=uploadEntity.getPvalid();
            if (valid!=-1&&valid!=1){
                if (yorn.equals("yes")){
                    valid = 1;   //verified
                    uploadService.updateValid(uploadEntity, valid, type);

                }else{
                    valid = -1;  //not verified
                    uploadService.updateValid(uploadEntity, valid, type);
                }
            }else{

            }
        }else{
            String description=uploadEntity.getDescription();
            valid=uploadEntity.getDvalid();
            if (valid!=-1&&valid!=1){
                if (yorn.equals("yes")){
                    valid = 1;   //verified
                    uploadService.updateValid(uploadEntity, valid, type);
                    //Update Food Table and Spot Table
                    FoodEntity foodEntity=foodService.getFoodDetail(spotfood);
                    if(foodEntity!=null){
                        foodService.updateDsp(foodEntity,description);
                    }else {
                        SpotEntity spotEntity=spotService.getSpotDetail(spotfood);
                        spotService.updateDsp(spotEntity,description);
                    }

                }else {
                    valid = -1;  //not verified
                    uploadService.updateValid(uploadEntity, valid, type);
                }
            }else{
            }

        }
        response.getWriter().append("123");
    }
}
