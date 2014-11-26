    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.fafiman.trabalhofinal.persistencia;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Marcelo
 */
public class Persistencia {

    private static final Logger logger = Logger.getLogger("br.com.proevents.persistencia.Persistencia");

    public static Object getId(Object entidade) {
        if (entidade == null) {
            return null;
        }
        try {
            Field f = getFieldId(entidade.getClass());
            if (f != null) {
                f.setAccessible(true);
                return f.get(entidade);
            } else {
                return null;
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Chave primária não encontrada para " + entidade, ex);
        }
        return null;
    }

    public static Field getFieldId(Class classe) {
        if (classe == null) {
            return null;
        }
        try {
            for (Field f : getAtributos(classe)) {
                if (f.isAnnotationPresent(Id.class)) {
                    return f;
                }
            }
        } catch (Exception ex) {
            logger.log(Level.SEVERE, "Chava primária não encontrada para " + classe, ex);
        }
        return null;
    }

    public static List<Field> getAtributos(Class classe) {
        List<Field> fields = new ArrayList<Field>();
        for (Field f : classe.getDeclaredFields()) {
            if (!classe.getSuperclass().equals(Object.class)) {
                fields.addAll(getAtributos(classe.getSuperclass()));
            }
            if (Modifier.isStatic(f.getModifiers())) {
                continue;
            }
            fields.add(f);
        }
        return fields;
    }

    public static Field primeiroAtributo(Class classe) {
        Field f = null;
        for (Field atributo : getAtributos(classe)) {
            if (Modifier.isStatic(atributo.getModifiers())) {
                continue;
            }
            if (f == null) {
                f = atributo;
            }
            if (!atributo.isAnnotationPresent(GeneratedValue.class)) {
                return atributo;
            } else if (f == null) {
                f = atributo;
            }
        }
        return f;
    }
}
