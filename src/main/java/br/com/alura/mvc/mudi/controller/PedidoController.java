package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.dto.RequisicaoNovoPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("pedido")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoRepository pedidoRepository;

    private static final String RETORNO_FORMULARIO = "pedido/formulario";

    @GetMapping("formulario")
    public String formulario(RequisicaoNovoPedido requisicao) {
        return RETORNO_FORMULARIO;
    }

    @PostMapping("novo")
    public String novo(@Valid RequisicaoNovoPedido requisicao, BindingResult result) {
        if(result.hasErrors()) {
            return RETORNO_FORMULARIO;
        }
        var pedido = requisicao.toPedido();
        pedidoRepository.save(pedido);
        return "redirect:/home";
    }
}
