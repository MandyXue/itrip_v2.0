package controller;


import org.eclipse.persistence.sessions.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.support.SessionStatus;
import service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;


/**
 * Created by Administrator on 2015/6/5.
 */
@Controller
@SessionAttributes("userId")
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    private String username;
    private String password;

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String Login(HttpServletRequest request, Model model, HttpSession session) throws Exception {
//        username = request.getParameter("username");
//        password = request.getParameter("password");
//        String checklog = loginService.check(username, password);
//        if (checklog == "success") {
//            model.addAttribute("userId", username);
//            return "home";
//        }
//
//        model.addAttribute("result", checklog);
//        model.addAttribute("name", username);
//        return "resultLog";
//    }

    @RequestMapping(value = "/result",method = RequestMethod.GET)
    public @ResponseBody
    String processAjaxRequest(
            Model model,
            @RequestParam(value = "username",required = true) String username,
            @RequestParam(value = "password",required = true) String password
    ){
        String checklog = loginService.check(username, password);
        model.addAttribute("name", "about");
        if (checklog.equals("success")) {
            model.addAttribute("userId", username);
        }
        return checklog;
    }
}
