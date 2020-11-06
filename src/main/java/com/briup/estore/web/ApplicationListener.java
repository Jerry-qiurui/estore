package com.briup.estore.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Book;
import com.briup.estore.bean.Category;
import com.briup.estore.dao.BookMapper;
import com.briup.estore.dao.CategoryMapper;
import com.briup.estore.util.MyBatisSqlSessionFactory;

/**
 * Application Lifecycle Listener implementation class ApplicationListener
 *
 */
@WebListener
public class ApplicationListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ApplicationListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	ServletContext application = arg0.getServletContext();
    	SqlSession sqlsession = MyBatisSqlSessionFactory.openSession(true);
    	BookMapper mapper = sqlsession.getMapper(BookMapper.class);
    	List<Book> list2 = mapper.findAll();
    	application.setAttribute("books", list2);
    	CategoryMapper mapper2 = sqlsession.getMapper(CategoryMapper.class);
		List<Category> list = mapper2.selectFID();
		HashMap<String, List<Category>> map = new HashMap<String,List<Category>>();
		for (Category category : list) {
			String fathername = category.getFatherCategory().getName();
			if(map.containsKey(fathername)) {
				List<Category> clist = map.get(fathername);
				clist.add(category);
			}else {
				ArrayList<Category> clist = new ArrayList<Category>();
				clist.add(category);
				map.put(fathername, clist);
			}
		}
		Set<Entry<String, List<Category>>> entrySet = map.entrySet();
//		for (Entry<String, List<Category>> entry : entrySet) {
//			System.out.println(entry.getKey() + ":" + entry.getValue());
//		}
		application.setAttribute("categories", map);
//		String name = null;
//		List<Category> one = new ArrayList<>();
//		List<Category> two = null;
//		for (Category category : list) {
//			String fatherName = category.getFatherCategory().getName();
//			if(!fatherName.equals(name) || name == null) {
//				if(two != null) {
//					application.setAttribute(name, two);
//				}
//				two = new ArrayList<>();
//				one.add(category.getFatherCategory());
//				name = fatherName;
//			}
//			two.add(category);
//		}
//		application.setAttribute("One", one);
//		
//		Object object = application.getAttribute("One");
//		List<Category> One = (List<Category>)object; 
//		One.forEach(i->System.out.println(i));
    }
	
}
