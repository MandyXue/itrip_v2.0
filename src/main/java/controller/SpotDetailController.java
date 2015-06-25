package controller;

import entity.FoodEntity;
import entity.SpotEntity;
import entity.UploadEntity;
import entity.UserSpotEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import service.FoodService;
import service.SpotService;
import service.UploadService;
import service.UserSpotService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by AngelYang on 2015/6/4.
 */
@Controller
@SessionAttributes("userId")
public class SpotDetailController {
    @Autowired
    private FoodService foodService;
    @Autowired
    private SpotService spotService;
    @Autowired
    private UserSpotService userSpotService;
    @Autowired
    private UploadService uploadService;

    private String username;
    private String spotfood;


    @RequestMapping(value = "/spot", method = RequestMethod.GET)
    public String showSpot(Model model,
                           @RequestParam(value = "province", required = true) String province,
                           @RequestParam(value = "spotName", required = true) String spotName,
                           HttpSession session) {
        username= (String) session.getAttribute("userId");
        spotfood= spotName;
        String checkup = uploadService.getCheck(username,spotfood);
        model.addAttribute("checkup",checkup);

        SpotEntity spotDetail = spotService.getSpotDetail(spotName);
        model.addAttribute("spotDetail", spotDetail);

        List<FoodEntity> provinceFoods = foodService.getProvinceFood(province);
        model.addAttribute("foods", provinceFoods);

        List<SpotEntity> provinceSpots = spotService.getProvinceSpots(province);
        model.addAttribute("spots", provinceSpots);

        String type = "spot";
        model.addAttribute("type", type);
        model.addAttribute("province", province);

        String userName=(String)session.getAttribute("userId");
        boolean userSpotPackage=userSpotService.findUserSpot(userName, spotName, "1");
        model.addAttribute("userSpotPackage",userSpotPackage);
        boolean userSpotCouple=userSpotService.findUserSpot(userName,spotName,"2");
        model.addAttribute("userSpotCouple",userSpotCouple);
        boolean userSpotFamily=userSpotService.findUserSpot(userName,spotName,"3");
        model.addAttribute("userSpotFamily",userSpotFamily);

        List<UploadEntity> validSpot= uploadService.getValid(spotName);
        int validSpotNum=validSpot.size();
        model.addAttribute("validSpot",validSpot);
        model.addAttribute("validSpotNum",validSpotNum);

        return "detail";
    }
}
