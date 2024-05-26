package br.com.fiap.collectage.controller.residencia;

import br.com.fiap.collectage.controller.URLs;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResidenciaController {

    @GetMapping(URLs.RESIDENCIAS)
    public String helloWorld() {
        return "Hello residencia";
    }

}
