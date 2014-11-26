/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fafiman.trabalhofinal.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author Marcelo
 */

@Entity
@PrimaryKeyJoinColumn(name = "idVeiculo")
public class Motocicleta extends Veiculo implements Serializable {

    private boolean temMataCachorro;

    public boolean isTemMataCachorro() {
        return temMataCachorro;
    }

    public void setTemMataCachorro(boolean temMataCachorro) {
        this.temMataCachorro = temMataCachorro;
    }
}
