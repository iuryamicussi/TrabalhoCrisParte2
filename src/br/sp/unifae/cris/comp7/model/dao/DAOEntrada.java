/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.unifae.cris.comp7.model.dao;

import br.sp.unifae.cris.comp7.model.Entrada;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;

/**
 *
 * @author Administrador
 */
public class DAOEntrada {
    public void armazenar(Entrada entrada) {
 

        Session session = DAOHibernateUtil.getSession();
 
        try {
 
            session.beginTransaction(); // Abre-se uma transação
            session.save(entrada);      // Acumula a operação de gravação do objeto entrada no BD, na transação
            session.getTransaction().commit();   // Realiza definitivamente todas as operações pendentes na transação
            JOptionPane.showMessageDialog(null, "Entrada armazenada com sucesso");
 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
 
        }
    }
 
    public void alterar(Entrada entrada) {
 
        Session session = DAOHibernateUtil.getSession();
 
        try {
 
            session.beginTransaction(); // Abre-se uma transação
            session.merge(entrada);      // Acumula a operação de alteração do objeto entrada no BD, na transação
            session.getTransaction().commit();   // Realiza definitivamente todas as operações pendentes na transação
            JOptionPane.showMessageDialog(null, "Entrada alterada com sucesso");
 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
 
        }
    }
 
    public void excluir(Entrada entrada) {
 
        Session session = DAOHibernateUtil.getSession();
 
        try {
 
            session.beginTransaction(); // Abre-se uma transação
            session.delete(entrada);    // Acumula a operação de exclusão do objeto entrada no BD, na transação
            session.getTransaction().commit();   // Realiza definitivamente todas as operações pendentes na transação
            JOptionPane.showMessageDialog(null, "Entrada excluída com sucesso");
 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
 
        }
    }
 
    public List listar() {
        Session session = DAOHibernateUtil.getSession();
        List listaEntradas = null;
        try {
            session.beginTransaction();           
            listaEntradas = session.createQuery("From Entrada").list();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        finally{
            session.close();
            return listaEntradas;
        }
    }
}
