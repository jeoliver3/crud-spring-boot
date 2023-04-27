package clinica.medica.api.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Spring MVC
@RestController // anotacao uada para APIS Rest
@RequestMapping("/hello") //mapeamento, que esse controller vai responder
public class HelloController {

    //qual método http é para chamar esse método
    @GetMapping
    public String olaMundo(){
        return "Hello World";
    }

}
