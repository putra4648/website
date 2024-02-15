package com.putra.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
    @GetMapping("/")
    public ModelAndView indexPage(ModelMap model) {
        model.put("isActive", true);
        return new ModelAndView("index.html");
    }

    @GetMapping("/portfolio")
    public ModelAndView portfolioPage(ModelMap model) {
        model.put("isActive", true);
        return new ModelAndView("portfolio.html", model);
    }

    @GetMapping("/work")
    public ModelAndView workPage(ModelMap model) {
        model.put("isActive", true);
        return new ModelAndView("portfolio.html", model);
    }

}
