package com.jordep.CadastroDeNinja.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

    @GetMapping("/helloWorld")
    public String getHelloWorld() {
        return "minha primeira rota GET";
    }

    @PostMapping("/helloWorld")
    public String postHelloWorld(String falaAlgumaCoisaMacaco) {
        return "minha primeira rota POST";
    }

    // essa bosta é uma nova branch

}
