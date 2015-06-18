package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by Administrator on 2015/6/5.
 */
@Controller
public class TologinController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String Login(Model model) {
        return "login";
    }
}
