package controller;


import model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PhoneController{
    @GetMapping("/user")
    public  ModelAndView home(Model model){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("phoneNumber", new PhoneNumber());
        return mv;
    }

    @PostMapping("/validate")
    public String getForm(@Valid @ModelAttribute("phoneNumber") PhoneNumber phoneNumber,
                                BindingResult bindingResult, Model model){
        new PhoneNumber().validate(phoneNumber, bindingResult);
        if(bindingResult.hasFieldErrors()){
            return "index";
        }
        model.addAttribute("phoneNumber", phoneNumber);
            return "result";
    }
}
