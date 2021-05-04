package client;

import java.util.Date;

import org.hibernate.Session;

import entity.Message;
import util.HibernateUtil;

public class HelloWorldClient {
	public static void main(String[] args) {
	    Message message = new Message( "Hello World and JPA Annotations after 1 days" );
        
        
				Session session = HibernateUtil.getSessionFactory().openSession();
        		session.beginTransaction();
        		
                // get id =1 from table and update data
                  Message emp = (Message) session.load(Message.class, new Long(7));
                  emp.setText("Update message at "+ new Date().toLocaleString()); 
                  session.saveOrUpdate(emp);
                 
        		//session.save(message);
        		session.getTransaction().commit();
        		
        		session.close();
	
	}
}

