package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2015/6/9.
 */
@Controller
public class TohomeController {
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String Home(Model model) {
        return "home";
    }
}
