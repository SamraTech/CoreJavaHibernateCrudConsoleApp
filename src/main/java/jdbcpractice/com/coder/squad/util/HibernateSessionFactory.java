package jdbcpractice.com.coder.squad.util;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
private static SessionFactory sf=null;
static {
	Configuration cfg = new Configuration();
	cfg.configure();
	// StandardServiceRegistry build =
	// builder.applySettings(cfg.getProperties()).build();
	 sf = cfg.buildSessionFactory();
	
	   
 	//sf = cfg.buildSessionFactory();
}
	 public static SessionFactory  getSessionFactory(){
	 	return sf;
	}
	public  static Session getSession(){
		SessionFactory sf = getSessionFactory();
		Session openSession = sf.openSession();
		return openSession;
	 }
	
}
