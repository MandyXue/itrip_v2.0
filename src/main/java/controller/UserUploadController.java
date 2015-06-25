package controller;

import entity.UploadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import service.UploadService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by mandyxue on 15/6/25.
 */
@Controller
@SessionAttributes("userId")
public class UserUploadController {
    @Autowired
    private UploadService uploadService;
    private String username;
    @RequestMapping(value = "/userupload", method = RequestMethod.GET)
    public String showupload(Model model,HttpSession session){
        username= (String) session.getAttribute("userId");
        List<UploadEntity> personalup = uploadService.getpersonal(username);
        model.addAttribute("userUpload",personalup);
        return "userupload";
    }
}
