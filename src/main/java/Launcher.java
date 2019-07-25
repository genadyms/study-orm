import java.util.List;

import javax.persistence.EntityManager;

import com.gmail.genadyms.parse.dao.entity.ProjectEntity;
import org.hibernate.Session;

import com.gmail.genadyms.parse.dao.factory.HibernateSessionFactory;

public class Launcher
{
	public static void main(String[] args)
	{
		EntityManager entityManager = HibernateSessionFactory.getSessionFactory().createEntityManager();
		List<ProjectEntity> resultList = entityManager.createQuery("select p from project p").getResultList();
		for(ProjectEntity p: resultList)
		{
			System.out.println(p);
		}
		entityManager.close();
	}

	private static void saveTestData()
	{
		System.out.println("App start!");

		Session session = HibernateSessionFactory.getSessionFactory().openSession();

		session.beginTransaction();
		ProjectEntity projectEntity = new ProjectEntity();
		projectEntity.setUniqueIdentifier("asdasdasdasd");
		projectEntity.setDescription("Description");
		session.save(projectEntity);
		session.getTransaction().commit();

		session.close();
	}
}
