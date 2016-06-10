package dao;

import model.Artigo;
import java.util.List;
 
public interface ArtigoDao {
 
 public void save(Artigo artigo);
 public Artigo getArtigo(long id);
 public List<Artigo> list();
 public void remove(Artigo artigo);
 public void update(Artigo artigo);
 
}
