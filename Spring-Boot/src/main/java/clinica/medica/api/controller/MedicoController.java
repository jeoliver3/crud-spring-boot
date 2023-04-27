package clinica.medica.api.controller;


import clinica.medica.api.medico.DadosCadastroMedico;
import clinica.medica.api.medico.DadoslistagemMedicos;
import clinica.medica.api.medico.Medico;
import clinica.medica.api.medico.MedicoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    //qual método http é para chamar esse método?
    //Se chegar uma requisição do tipo Post, para URL /medicos, chame o método cadastrar da classe Medico do Controller
    // método cadastrar vai pegar o Repository e mandar persistir Medico no banco de dados


    // injeçao de dependencias com Autowired
    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroMedico dados){
        //chamando o dados do body da requisição
        // método save vai fazer o insert na tabela do banco de dados
        repository.save(new Medico(dados));

        }

    // Devolvendo uma info para o cliente que está chamando uma API

    @GetMapping
    public List<DadoslistagemMedicos> listar(Pageable paginacao) {
        return repository.findAll().stream().map(DadoslistagemMedicos::new).collect(Collectors.toList()); //convertendo para uma lista

    }

    /*
    // com Pageable o Spring monta a query com a paginação, devolvendo infos da paginação
        @GetMapping
        public Page<DadosListagemMedico> listar(Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemMedico::new);


        @PutMapping
        @Transactional
         public void atualizar(@RequestBody @Valid DadosCadastroMedico dados) {

    }
    }

    @DeleteMapping("/{id}") //Spring sabe se chegar uma requisiçao para / medicos é para chamar MedicosController
     @Transactional
    public void excluir(@PathVariableLong id){
    repository.deleteById(id)
    }
     */
}
