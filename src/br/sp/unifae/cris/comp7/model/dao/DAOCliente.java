package br.sp.unifae.cris.comp7.model.dao;

import br.sp.unifae.cris.comp7.model.Cliente;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;

/**
 *
 * @author Nora
 */
public class DAOCliente {
    
    public void armazenar(Cliente cliente) {
 

        Session session = DAOHibernateUtil.getSession();
 
        try {
 
            session.beginTransaction(); // Abre-se uma transação
            session.save(cliente);      // Acumula a operação de gravação do objeto produto no BD, na transação
            session.getTransaction().commit();   // Realiza definitivamente todas as operações pendentes na transação
            JOptionPane.showMessageDialog(null, "Cliente armazenado com sucesso");
 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
 
        }
    }
    
    public void alterar(Cliente cliente) {
 
        Session session = DAOHibernateUtil.getSession();
 
        try {
 
            session.beginTransaction(); // Abre-se uma transação
            session.merge(cliente);      // Acumula a operação de alteração do objeto produto no BD, na transação
            session.getTransaction().commit();   // Realiza definitivamente todas as operações pendentes na transação
            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso");
 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
 
        }
    }
    
    public void excluir(Cliente cliente) {
 
        Session session = DAOHibernateUtil.getSession();
 
        try {
 
            session.beginTransaction(); // Abre-se uma transação
            session.delete(cliente);    // Acumula a operação de exclusão do objeto produto no BD, na transação
            session.getTransaction().commit();   // Realiza definitivamente todas as operações pendentes na transação
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso");
 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
 
        }
    }
    
    public List listar() {
        Session session = DAOHibernateUtil.getSession();
        List listaCliente = null;
        try {
            session.beginTransaction();           
            listaCliente = session.createQuery("From Cliente").list();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        finally{
            session.close();
            return listaCliente;
        }
    }
}
