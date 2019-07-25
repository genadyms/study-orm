import com.gmail.genadyms.parse.dao.entity.ProjectEntity;
import com.gmail.genadyms.parse.dao.factory.HibernateSessionFactory;
import org.hibernate.Session;

public class Launcher
{
	public static void main(String[] args)
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
