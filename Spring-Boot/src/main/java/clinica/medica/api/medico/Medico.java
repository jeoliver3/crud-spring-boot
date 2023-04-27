package clinica.medica.api.medico;

/*
Para fazer a persistência, pegar o objeto Medico e salvar no banco de dados, o Spring Data tem o
Repository, que são interfaces. O Spring já nos fornece a implementação.
Vamos criar uma nova interface em "java > clinica.medica.api > Medico". E selecionar a opção "Interface".
O nome será "MedicoRepository".

Criaremos uma interface Java, sem elementos do Spring Data. Vamos herdar de uma interface chamada
JpaRepository, usando um extends. Entre <>, passaremos dois tipos de objeto.
 */
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="medicos")
@Entity(name="Medico")

// com Lombok para gerar getters,setters e anotacoes em tempo de compilaçao automaticamente
@Getter
//noArgsConstructor para gerar construtor default sem parametros, que JPA exige em todas as entidades
@NoArgsConstructor
@AllArgsConstructor
// para gerar hashcode em cima do id e nao dos demais atributos
@EqualsAndHashCode(of ="id" )
public class Medico {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;


    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    public Medico (DadosCadastroMedico dados){
        //this.nome = dados.nome();
        //this.email = dados.email();
        //this.crm=dados.crm();
        //this.especialidade=dados.especialidade();

    }

}
