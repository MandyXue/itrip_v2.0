package controller;

import javafx.scene.effect.Light;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.SpotService;
import service.UserSpotService;

import javax.servlet.http.HttpSession;

/**
 * Created by AngelYang on 2015/6/5.
 */
@Controller
public class SpotThumbController {
    @Autowired
    UserSpotService userSpotService;
    @Autowired
    SpotService spotService;

    @RequestMapping(value = "/spotThumbs", method = RequestMethod.GET)
    public
    @ResponseBody
    String showPackage(
            @RequestParam(value = "spotName", required = true) String spotName,
            @RequestParam(value = "type", required = true) String type, HttpSession session) {
        int spotThumbs;
        String userName = (String) session.getAttribute("userId");

        //已经存在点赞记录,删除
        if (userSpotService.findUserSpot(userName, spotName, type)) {
            userSpotService.removeUserSpot(userName, spotName, type);
            spotThumbs = spotService.dropSpotThumbs(spotName, type);
        }

        //新增点赞记录
        else if (userName.equals(null)) {
            spotThumbs = spotService.addSpotThumbs(spotName, type);
        } else {
            spotThumbs = spotService.addSpotThumbs(spotName, type);
            userSpotService.addUserSpot(userName, spotName, type);
        }

        return Integer.toString(spotThumbs);
    }
}
