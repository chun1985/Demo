
package springMVC.controller;

import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import springMVC.model.Receipt;

@Controller
@RequestMapping("/")
public class ReceiptController {
	@RequestMapping( method = RequestMethod.GET)
	public String homeGet(ModelMap model) {
		return "ReceiptMonth";
	}

	@RequestMapping( method = RequestMethod.POST)
	public String homePost(ModelMap model) {
		return "ReceiptMonth";
	}
	
	@RequestMapping(value = "/receiptNumber", method = RequestMethod.POST)
	public String numberHome(ModelMap model) {
		return "ReceiptNumber";
	}

	@RequestMapping(value = "/receiptData", method = RequestMethod.POST)
	public String dataHome(ModelMap model) {
		return "ReceiptData";
	}
	
	@RequestMapping(value = "/pwChange", method = RequestMethod.POST)
	public String pwChange(ModelMap model) {
		return "AdminPWchange";
	}
	
	@RequestMapping(value = "/pwChangeOut", method = RequestMethod.POST)
	public String pwChangeOut(ModelMap model) {
		return "AdminPWchangeOut";
	}

	@RequestMapping(value = "/queryReceipt", method = RequestMethod.POST)
	public ModelAndView listReceipt(@ModelAttribute("Receipt") Receipt rc) {
		return new ModelAndView("showReceipt", "message", getData(rc.getTime()));
	}

	private List<Receipt> getData(String time) {
		SessionFactory sessionFactory = null;
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure() // hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry);
			System.out.println("Setup Failed:" + ex.getMessage());
		}
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			List data = null;
			tx = session.beginTransaction();
			if (time != "" && time != null) {
				String hql = "FROM Receipt R WHERE R.time = :time";
				Query query = session.createQuery(hql);
				query.setParameter("time", time);
				data = query.list();
			} else {
				data = session.createQuery("FROM Receipt").list();
			}
			for (Iterator iterator = data.iterator(); iterator.hasNext();) {
				Receipt rc = (Receipt) iterator.next();
			}
			tx.commit();
			return data;
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	private void addRc(Receipt rc) {
		SessionFactory sessionFactory = null;
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry);
			System.out.println("Setup Failed:" + ex.getMessage());
		}
		Session sessionObj = sessionFactory.openSession();
		try {
			sessionObj.beginTransaction();
			sessionObj.save(rc);
			System.out.println("\n.......Records Saved Successfully To The Database.......\n");
			sessionObj.getTransaction().commit();
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
	}

	@RequestMapping(value = "/addReceipt", method = RequestMethod.POST)
	public ModelAndView addReceipt(@ModelAttribute("Receipt") Receipt rc) {
		addRc(rc);
		return new ModelAndView("showReceipt", "message", getData(""));
	}

	private void updateRc(Receipt rc) {
		SessionFactory sessionFactory = null;
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry);
			System.out.println("Setup Failed:" + ex.getMessage());
		}
		Session sessionObj = sessionFactory.openSession();
		try {
			sessionObj.beginTransaction();
			sessionObj.update(rc);
			System.out.println("\n.......Records Saved Successfully To The Database.......\n");
			sessionObj.getTransaction().commit();
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
	}

	@RequestMapping(value = "/updateReceipt", method = RequestMethod.POST)
	public ModelAndView updateReceipt(@ModelAttribute("Receipt") Receipt rc) {
		updateRc(rc);
		return new ModelAndView("showReceipt", "message", getData(""));
	}

	private void deleteRc(Receipt rc) {
		SessionFactory sessionFactory = null;
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		try {
			sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		} catch (Exception ex) {
			StandardServiceRegistryBuilder.destroy(registry);
			System.out.println("Setup Failed:" + ex.getMessage());
		}
		Session sessionObj = sessionFactory.openSession();
		try {
			sessionObj.beginTransaction();
			sessionObj.delete(rc);
			System.out.println("\n.......Records Saved Successfully To The Database.......\n");
			sessionObj.getTransaction().commit();
		} catch (Exception sqlException) {
			if (null != sessionObj.getTransaction()) {
				System.out.println("\n.......Transaction Is Being Rolled Back.......");
				sessionObj.getTransaction().rollback();
			}
			sqlException.printStackTrace();
		} finally {
			if (sessionObj != null) {
				sessionObj.close();
			}
		}
	}

	@RequestMapping(value = "/deleteReceipt", method = RequestMethod.POST)
	public ModelAndView deleteReceipt(@ModelAttribute("Receipt") Receipt rc) {
		deleteRc(rc);
		return new ModelAndView("showReceipt", "message", getData(""));
	}
}