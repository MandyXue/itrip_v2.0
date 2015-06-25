package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.RegisterService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * Created by Administrator on 2015/6/5.
 */
@Controller
@SessionAttributes("userId")
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private RegisterService registerService;
    private String username;
    private String password;
    private String email;

//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public String Login(HttpServletRequest request, Model model, HttpSession session) throws Exception {
//        username = request.getParameter("username");
//        password = request.getParameter("password");
//        email = request.getParameter("email");
//        String checkreg = registerService.check(username, password, email);
//        if (checkreg == username) {
//            model.addAttribute("userId", username);
//            return "home";
//        }
//        model.addAttribute("result", checkreg);
//        model.addAttribute("name", username);
//        return "resultReg";
//    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public @ResponseBody
    String registerAjaxRequest(
            Model model,
            @RequestParam(value = "username",required = true) String username,
            @RequestParam(value = "email",required = true) String email,
            @RequestParam(value = "password",required = true) String password,
            @RequestParam(value = "password2",required = true) String password2
    ) throws Exception {
        String checkreg = registerService.check(username, password, email,password2);
        if (checkreg == "success") {
            model.addAttribute("userId", username);
            return "success";
        }
//        model.addAttribute("result", checkreg);
//        model.addAttribute("name", username);
        return checkreg;
    }
}
