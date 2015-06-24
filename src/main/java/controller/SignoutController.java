package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2015/6/9.
 */
@Controller
@SessionAttributes("userId")
public class SignoutController {
    @RequestMapping(value = "/signout", method = RequestMethod.GET)
    public String Signout(Model model, HttpSession session, SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/home";
    }
}
