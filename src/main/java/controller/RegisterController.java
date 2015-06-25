package controller;

import entity.UsertableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import service.RegisterService;

import javax.validation.Valid;

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
    public String Login(Model model)  {
        UsertableEntity register=new UsertableEntity();
        model.addAttribute("register", register);
        return "register";
    }



    @RequestMapping(value = "/register/result", method = RequestMethod.POST)
    public @ResponseBody
    String registerAjaxRequest(@Valid @ModelAttribute("register")UsertableEntity register,BindingResult result,
            Model model,
            @RequestParam(value = "password2",required = true) String password2
    ) {
        if(result.hasErrors()){
            return "register";
        }

        String username=register.getUsername();
        String password=register.getPassword();
        String email=register.getEmail();
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
