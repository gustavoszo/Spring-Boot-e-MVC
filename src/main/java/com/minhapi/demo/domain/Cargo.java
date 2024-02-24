package com.minhapi.demo.domain;

import java.util.List;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "cargos") 
@AttributeOverride(name = "id", column = 
@Column(name = "id_cargo"))
public class Cargo extends AbstractEntity<Long> {

    @OneToMany(mappedBy = "cargo")
    private List<Funcionario> funcionarios;
    
    @NotBlank(message = "Informe um nome")
    @Size(min = 3, max = 60, message = "O nome do cargo dever ter entre {min} e {max} caracteres")
    @Column(name = "nome", nullable = false, unique = true, length = 100)
    private String nome;

    @NotNull(message = "Informe um departamento")
    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

}
