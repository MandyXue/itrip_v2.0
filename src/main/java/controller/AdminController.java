package controller;

import entity.UploadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.UploadService;

import java.util.List;

/**
 * Created by AngelYang on 2015/6/12.
 */
@Controller
public class AdminController {
    @Autowired
    UploadService uploadService;

    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public String admin(Model model){
        List<UploadEntity> uploadEntities=uploadService.findAllUploads();
        model.addAttribute("uploadEntities",uploadEntities);

        return "admin";
    }
}
