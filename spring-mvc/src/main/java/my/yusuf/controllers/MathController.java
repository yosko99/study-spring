package my.yusuf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MathController {
    @RequestMapping("/add")
    public ModelAndView add(@RequestParam("firstNumber") int firstNumber, @RequestParam("secondNumber") int secondNumber) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("calculate");
        modelAndView.addObject("result", firstNumber + secondNumber);

        return modelAndView;
    }
}
