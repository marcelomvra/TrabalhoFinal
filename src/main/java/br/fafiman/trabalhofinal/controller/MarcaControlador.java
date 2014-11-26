/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fafiman.trabalhofinal.controller;

import br.fafiman.trabalhofinal.entidades.Marca;
import br.fafiman.trabalhofinal.busines.MarcaDAO;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Marcelo
 */
@SessionScoped
@ManagedBean
public class MarcaControlador implements Serializable {

    private Marca entidade;
    private MarcaDAO marcaDAO = new MarcaDAO();
    

    public Marca getEntidade() {
        return entidade;
    }
    public void setEntidade(Marca entidade) {
        this.entidade = entidade;
    }

    public MarcaDAO getMarcaDAO() {
        return marcaDAO;
    }

    public void setMarcaDAO(MarcaDAO marcaDAO) {
        this.marcaDAO = marcaDAO;
    }
       
    public void novo(){
        entidade = new Marca();        
    }
    
    public void salvar(){
        marcaDAO.persistir(entidade);
        System.out.println("O objeto foi salvo com sucesso.");
    }
    
}
