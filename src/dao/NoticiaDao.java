package dao;

import model.Noticia;
import java.util.List;
 
public interface NoticiaDao {
 
 public void save(Noticia noticia);
 public Noticia getNoticia(long id);
 public List<Noticia> list();
 public void remove(Noticia noticia);
 public void update(Noticia noticia);
 
}
