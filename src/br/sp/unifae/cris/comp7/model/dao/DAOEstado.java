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
 * @author iury
 */
public class DAOEstado {
    public List listar() {
        Session session = DAOHibernateUtil.getSession();
        List listaEstado = null;
        try {
            session.beginTransaction();           
            listaEstado = session.createQuery("From Estado").list(); 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        finally{
            session.close();
            return listaEstado;
        }
    }
}
