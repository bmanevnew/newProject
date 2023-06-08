package com.example.newproject.controllers.mvc;

import com.example.newproject.models.QouteDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeMvcController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/request-a-quote.html")
    public String qoute() {
        return "request-a-quote";
    }

    @PostMapping("/request-a-quote.html")
    public String showContactPage(Model model) {
        model.addAttribute("qputeDto", new QouteDto());
        return "request-a-quote";
    }
}
