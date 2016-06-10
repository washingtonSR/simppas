package dao;

import model.Evento;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtil;

public class EventoDaoImp implements EventoDao {
	public void save(Evento evento) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.save(evento);
		t.commit();
	}
	
	public Evento getEvento(long id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		return (Evento) session.load(Evento.class, id);
	}
	
	public List<Evento> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		List lista = session.createQuery("from Evento").list();
		t.commit();
		return lista;
	}
	
	public void remove(Evento evento) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.delete(evento);
		t.commit();
	}
	
	public void update(Evento evento) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		session.update(evento);
		t.commit();
	}
}
