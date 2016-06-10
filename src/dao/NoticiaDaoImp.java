package dao;

import model.Noticia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtil;

public class NoticiaDaoImp implements NoticiaDao {
	public void save(Noticia noticia) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(noticia);
		t.commit();
	}
	
	public Noticia getNoticia(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Noticia) session.load(Noticia.class, id);
	}
	
	public List<Noticia> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from Noticia").list();
		t.commit();
		return lista;
	}
	
	public void remove(Noticia noticia) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(noticia);
		t.commit();
	}
	
	public void update(Noticia noticia) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(noticia);
		t.commit();
	}
}
