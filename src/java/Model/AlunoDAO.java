package Model;

import Hibernate.NewHibernateUtil;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;

/**
 *
 * @author Ismael(figur8)
 *  -Agradecimentos:devmedia.com
 */

public class AlunoDAO {
    
   protected EntityManager entityManager;
   public void salvar(Aluno aluno){
       Session sessao = NewHibernateUtil.getSessionFactory().openSession();
       sessao.beginTransaction();
       sessao.persist(aluno);
       sessao.getTransaction().commit();
       sessao.close();
   }
   public List<Aluno> listar(){
       Session sessao = NewHibernateUtil.getSessionFactory().openSession();
       List<Aluno> lista = sessao.getNamedQuery("Aluno.findAll").list();
       sessao.close();
       
       return lista;
   }
   public Aluno buscarPeloId(final String id){
       Session sessao = NewHibernateUtil.getSessionFactory().openSession();
       return entityManager.find(Aluno.class, id);
   }
}
