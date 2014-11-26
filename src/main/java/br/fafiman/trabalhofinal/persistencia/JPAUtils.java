/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fafiman.trabalhofinal.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Marcelo
 */
public class JPAUtils {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalhoPU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void closeConnection() {
        emf.close();
    }
}
