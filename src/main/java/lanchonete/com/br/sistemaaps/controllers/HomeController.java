
package lanchonete.com.br.sistemaaps.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    // Metodo para redirecinar a URL
    // Toda vez que acessar a URL passada na @RequestMapping, no caso é o root, vai retornar um /index
    //Esse /index vai ser tratado conforme foi passado os padrões no AppWebConfig
    @RequestMapping("/")
    public String index(){
        return "index"; 
    }

    @RequestMapping("/cadastro")
    public String Cadastro(){
        return "cadastro"; 
    }
}
