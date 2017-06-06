/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.unifae.cris.comp7.model.dao;

import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;

/**
 *
 * @author Administrador
 */
public class DAOGenerica {
    
    public List listar(String pesquisa) {
        Session session = DAOHibernateUtil.getSession();
        List lista = null;
        try {
            session.beginTransaction();
            lista = session.createSQLQuery(pesquisa).list();
            //lista = session.createQuery(pesquisa).list();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        finally{
            session.close();
            return lista;
        }
    }
    
}
