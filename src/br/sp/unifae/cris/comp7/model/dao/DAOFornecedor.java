package br.sp.unifae.cris.comp7.model.dao;

import br.sp.unifae.cris.comp7.model.Fornecedor;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;

/**
 *
 * @author Nora
 */
public class DAOFornecedor {
    
    public void armazenar(Fornecedor fornecedor) {
 

        Session session = DAOHibernateUtil.getSession();
 
        try {
 
            session.beginTransaction(); // Abre-se uma transação
            session.save(fornecedor);      // Acumula a operação de gravação do objeto produto no BD, na transação
            session.getTransaction().commit();   // Realiza definitivamente todas as operações pendentes na transação
            JOptionPane.showMessageDialog(null, "Fornecedor armazenado com sucesso");
 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
 
        }
    }
    
    public void alterar(Fornecedor fornecedor) {
 
        Session session = DAOHibernateUtil.getSession();
 
        try {
 
            session.beginTransaction(); // Abre-se uma transação
            session.merge(fornecedor);      // Acumula a operação de alteração do objeto produto no BD, na transação
            session.getTransaction().commit();   // Realiza definitivamente todas as operações pendentes na transação
            JOptionPane.showMessageDialog(null, "Fornecedor alterado com sucesso");
 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
 
        }
    }
    
    public void excluir(Fornecedor fornecedor) {
 
        Session session = DAOHibernateUtil.getSession();
 
        try {
 
            session.beginTransaction(); // Abre-se uma transação
            session.delete(fornecedor);    // Acumula a operação de exclusão do objeto produto no BD, na transação
            session.getTransaction().commit();   // Realiza definitivamente todas as operações pendentes na transação
            JOptionPane.showMessageDialog(null, "Fornecedor excluído com sucesso");
 
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
 
        }
    }
    
    public List listar() {
        Session session = DAOHibernateUtil.getSession();
        List listaFornecedor = null;
        try {
            session.beginTransaction();           
            listaFornecedor = session.createQuery("From Fornecedor").list();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        finally{
            session.close();
            return listaFornecedor;
        }
    }
}