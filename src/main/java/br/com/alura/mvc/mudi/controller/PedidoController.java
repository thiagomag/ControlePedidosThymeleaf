package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.dto.RequisicaoNovoPedido;
import br.com.alura.mvc.mudi.model.User;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import br.com.alura.mvc.mudi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
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
    private final UserRepository userRepository;

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

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username);

        var pedido = requisicao.toPedido();
        pedido.setUser(user);
        pedidoRepository.save(pedido);
        return "redirect:/home";
    }
}
