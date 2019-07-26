import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.gmail.genadyms.parse.dao.entity.ProjectEntity;
import org.hibernate.Session;

import com.gmail.genadyms.parse.dao.factory.HibernateSessionFactory;
import org.hibernate.SessionFactory;

public class Launcher
{
	public static void main(String[] args)
	{
		getDataByJPQL();
	}

	// not working with criteria
	private static void getDataByCriteria()
	{
		SessionFactory sessionFactory = HibernateSessionFactory.getSessionFactory();
		EntityManager entityManager = sessionFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		List<ProjectEntity> list = sessionFactory.getCurrentSession().createCriteria(ProjectEntity.class).list();
		for(ProjectEntity projectEntity: list)
		{
			System.out.println(projectEntity);
		}
		transaction.commit();
	}

	private static void getDataByJPQL()
	{
		EntityManager entityManager = HibernateSessionFactory.getSessionFactory().createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		List<ProjectEntity> resultList = entityManager.createQuery("select p from project p").getResultList();
		for(ProjectEntity p: resultList)
		{
			System.out.println(p);
		}
		resultList.get(0).setUniqueIdentifier("uid1");
		transaction.commit();
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
