package br.com.atividade3.pontos;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Controller
@RequestMapping("/")
public class Controles {

    RestTemplate rest = new RestTemplate();

    @GetMapping
    String index() {
      
        return "Navegar/index";
    }



    @GetMapping("/realDolar")
    String cedulaA(Model model) {
    	List<valorDodia> realXdolar = rest.getForObject("https://economia.awesomeapi.com.br/BRL-USD/1" , List.class);
    	model.addAttribute("objetos", realXdolar);
        return "Navegar/pagina";
    }
    
    
    @GetMapping("/dolarReal")
    String cedulaB(Model model) {
    	List<valorDodia> dolarXreal = rest.getForObject("https://economia.awesomeapi.com.br/USD-BRL/1" , List.class);
        model.addAttribute("objetos", dolarXreal);
        return "Navegar/pagina";
    }



}
