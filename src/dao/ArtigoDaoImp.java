package dao;

import model.Artigo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtil;

public class ArtigoDaoImp implements ArtigoDao {

	public void save(Artigo artigo) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(artigo);
		t.commit();
	}
	
	public Artigo getLivro(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Artigo) session.load(Artigo.class, id);
	}
	
	public List<Artigo> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from Artigo").list();
		t.commit();
		return lista;
	}
	
	public void remove(Artigo artigo) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(artigo);
		t.commit();
	}
	
	public void update(Artigo artigo) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(artigo);
		t.commit();
	}
}
