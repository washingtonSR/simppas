package dao;

import model.Evento;
import java.util.List;
 
public interface EventoDao {
 
 public void save(Evento evento);
 public Evento getEvento(long id);
 public List<Evento> list();
 public void remove(Evento evento);
 public void update(Evento evento);

}
