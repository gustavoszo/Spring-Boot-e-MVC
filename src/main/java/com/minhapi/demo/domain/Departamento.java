package com.minhapi.demo.domain;

import java.util.List;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "departamentos")
@AttributeOverride(name = "id", column = 
@Column(name = "id_departamento"))
public class Departamento extends AbstractEntity<Long> {

    @OneToMany(mappedBy = "departamento") // atributo departamento da classe Cargo (Lado forte da relação Cargo, lado fraco departamento)
    private List<Cargo> cargos;

    @NotBlank(message = "Informe um nome")
    @Size(max = 60, message = "O nome deve ter o máximo de 60 caracteres")
    @Column(name = "nome", nullable = false, unique = true, length = 100)
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setCargos(List<Cargo> cargos) {
        this.cargos = cargos;
    }

    public List<Cargo> getCargos() {
        return cargos;
    }

}