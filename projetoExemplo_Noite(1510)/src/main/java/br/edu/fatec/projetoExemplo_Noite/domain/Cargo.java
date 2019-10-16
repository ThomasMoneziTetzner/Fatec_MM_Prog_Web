package br.edu.fatec.projetoExemplo_Noite.domain;

import javax.persistence.*;
import java.util.List;

@SuppressWarnings("serial")
@Entity
@Table(name = "CARGOS")
public class Cargo extends AbstractEntity<Long> {

    @Column(name = "nome", nullable = false, unique = true, length = 60)
    private String nome;

    //mapeando o atributo referente a chave estrangeira em um relacionamento um para muitos
    @ManyToOne
    //dando nome a chave estrangeira de um relacionamento 1xN
    @JoinColumn(name = "id_departamento_fk")
    private Departamento departamento;

    //mapeando o lado fraco da relação um para muitos
    @OneToMany(mappedBy = "cargo")
    private List<Funcionario> funcionarios;

    //métodos get/set
    public String getNome() {
        return nome;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}