/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.unifae.cris.comp7.model.dao;

import br.sp.unifae.cris.comp7.model.EntradaProduto;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;

/**
 *
 * @author Administrador
 */
public class DAOEntradaProduto {
    public void armazenar(EntradaProduto entradaProduto) {
 
        Session session = DAOHibernateUtil.getSession();
 
        try {
 
            session.beginTransaction(); // Abre-se uma transação
            session.save(entradaProduto);      // Acumula a operação de gravação do objeto entrada no BD, na transação
            session.getTransaction().commit();   // Realiza definitivamente todas as operações pendentes na transação
 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
 
        }
    }
 
    public void alterar(EntradaProduto entradaProduto) {
 
        Session session = DAOHibernateUtil.getSession();
 
        try {
 
            session.beginTransaction(); // Abre-se uma transação
            session.merge(entradaProduto);      // Acumula a operação de alteração do objeto entrada no BD, na transação
            session.getTransaction().commit();   // Realiza definitivamente todas as operações pendentes na transação
 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
 
        }
    }
 
    public void excluir(EntradaProduto entradaProduto) {
 
        Session session = DAOHibernateUtil.getSession();
 
        try {
 
            session.beginTransaction(); // Abre-se uma transação
            session.delete(entradaProduto);    // Acumula a operação de exclusão do objeto entrada no BD, na transação
            session.getTransaction().commit();   // Realiza definitivamente todas as operações pendentes na transação
 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
 
        }
    }
 
    public List listar(int entradaId) {
        Session session = DAOHibernateUtil.getSession();
        List listaEntradas = null;
        try {
            session.beginTransaction();
            listaEntradas = session.createSQLQuery("Select * From EntradaProduto Where id_entrada = " + entradaId).list();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        finally{
            session.close();
            return listaEntradas;
        }
    }
}
