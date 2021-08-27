package br.com.alura.mvc.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("oferta")
public class OfertaController {

    @GetMapping
    public String getFormularioPedidosParaOfertas() {
        return "oferta/home";
    }
}
