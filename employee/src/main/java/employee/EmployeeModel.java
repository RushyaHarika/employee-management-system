package employee;


import java.util.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



@SuppressWarnings("deprecation")
public class EmployeeModel {

	private SessionFactory sessionFactory = EmployeeUtil.getSessionFactory();
	Scanner sc = new Scanner(System.in);	
	List<User> employees;
	public boolean create(Employee emp) {
		boolean result = true;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(emp);
			transaction.commit();
		} catch (Exception e) {
			result = false;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}
	
	public boolean remove(int id) {
		boolean result = true;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("delete from Employee emp where eid ="+id);
			int status = query.executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			result = false;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}
	
	public List<User> view() {
		boolean result = true;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Query query1 = session.createQuery("from User");
			 employees = query1.list();//method to fetch values
			for(User e : employees ) {
				System.out.println("[ eid="+e.getEid() + " ename=" + e.getEname() +" erole="+ e.getErole()+" eproject=" + e.getEproject()+" ]");
			}
			query1.executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			result = false;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return employees;		
	}		
	
	public boolean addProject(Project pro) {
		boolean result = true;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(pro);
			transaction.commit();
		} catch (Exception e) {
			result = false;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}

	public boolean allocateProject(int empid, int projid) {
		boolean result = true;
		Session session = null;
		Transaction transaction = null;
		int flag=0;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("from Project");
			List<Project> projects = query.list();
			for(Project p : projects ) {
				if(p.getPid() == projid) {
					Query query1 = session.createQuery("update User u set u.eproject="+projid+" where u.eid="+empid);
					int status1 = query1.executeUpdate();
					flag=1;
					break;
				}
			}
			
			if(flag==0) {
				System.out.println("Invalid Project");
			}
			transaction.commit();
		} catch (Exception e) {
			result = false;
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}
		return result;
	}
}