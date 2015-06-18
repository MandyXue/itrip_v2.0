package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import service.RegisterService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

/**
 * Created by Administrator on 2015/6/5.
 */
@Controller
@SessionAttributes("userId")
public class RegisterController {
    @Autowired
    private RegisterService registerService;
    private String username;
    private String password;
    private String email;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String Login(HttpServletRequest request, Model model, HttpSession session) throws Exception {
        username = request.getParameter("username");
        password = request.getParameter("password");
        email = request.getParameter("email");
        String checkreg = registerService.check(username, password, email);
        if (checkreg == username) {
            model.addAttribute("userId", username);
            return "home";
        }
        model.addAttribute("result", checkreg);
        model.addAttribute("name", username);
        return "resultReg";
    }
}
