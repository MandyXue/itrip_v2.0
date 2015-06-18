package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by Administrator on 2015/6/5.
 */
@Controller
public class ToregisterController {
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String Register(Model model) {
        return "register";
    }
}
