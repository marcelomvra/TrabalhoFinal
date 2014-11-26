/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fafiman.trabalhofinal.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author Marcelo
 */

@Entity
@PrimaryKeyJoinColumn(name="idVeiculo")
public class Automovel extends Veiculo implements Serializable {  
  
    private String capacidadePortaMalas;

    public String getCapacidadePortaMalas() {
        return capacidadePortaMalas;
    }

    public void setCapacidadePortaMalas(String capacidadePortaMalas) {
        this.capacidadePortaMalas = capacidadePortaMalas;
    }     
}
