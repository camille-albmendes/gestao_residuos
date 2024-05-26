package br.com.fiap.collectage.controller.residencia;

import br.com.fiap.collectage.controller.URLs;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(URLs.RESIDENCIA)
public class ResidenciaController {

    @GetMapping
    public String helloWorld() {
        return "Hello residencia";
    }

}
