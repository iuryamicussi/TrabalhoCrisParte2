/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.sp.unifae.cris.comp7.model.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author iury
 */
public class DAOHibernateUtil {
    
    protected DAOHibernateUtil(){
    }
    
    /**
     *
     * @return 
     */
    public static Session getSession(){
        Session session = (Session) DAOHibernateUtil.session.get();
        
        if(session == null || !session.isOpen()){
            session = sessionFactory.openSession();
            DAOHibernateUtil.session.set(session);
        }
        
        return session;
    }
    
    protected void begin(){
        getSession().beginTransaction();
    }
    
    protected void commit(){
        getSession().getTransaction().commit();
    }
    
    protected void rollback(){
        try{
            getSession().getTransaction().rollback();
        }
        catch(HibernateException e){
            System.out.println("Não foi possível fazer rollback da transação");
            throw e;
        }
        
        try{
            getSession().close();
        }
        catch(HibernateException e){
            System.out.println("Não foi possível fazer fechar a sessão");
            throw e;
        }
        
        DAOHibernateUtil.session.set(null);
    }
    
    public static void close(){
        getSession().close();
        DAOHibernateUtil.session.set(null);
    }
    
    private static final ThreadLocal session = new ThreadLocal();
    
    public static final SessionFactory sessionFactory = 
            new AnnotationConfiguration().configure().buildSessionFactory();
        
}
