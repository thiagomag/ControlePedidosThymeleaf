package br.com.alura.mvc.mudi.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String Hello(HttpServletRequest request) {
        request.setAttribute("nome", "Mundo");
        return "hello";
    }
}
