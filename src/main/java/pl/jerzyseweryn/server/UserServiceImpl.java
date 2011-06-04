package pl.jerzyseweryn.server;

import java.util.ArrayList;
import java.util.List;

import pl.jerzyseweryn.client.service.UserService;
import pl.jerzyseweryn.client.shared.UserBean;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.NotFoundException;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.Query;

public class UserServiceImpl extends RemoteServiceServlet implements
		UserService {

	// private AtomicInteger idGenerator = new AtomicInteger(0);

	/**
	 * 
	 */
	private static final long serialVersionUID = 472628237582861923L;

	public UserBean login(UserBean user) {
		if (Constants.MOCK_DATA) {
			System.out.println("Logowanie, login: " + user.getFirstName()
					+ " password: " + user.getLastName());
			user.setResponseCode(UserBean.SUCCESS_CODE);
			if (!user.getFirstName().equals(user.getLastName())) {
				user.setFirstName("error");
				user.setResponseCode(UserBean.ERROR_CODE);
			}
		} else {
			ObjectifyFactory fact = new ObjectifyFactory();
			fact.register(UserBean.class);
			Objectify ofy = fact.begin();
			try {
				UserBean u = ofy.get(UserBean.class, user.getFirstName());
				if (u.getLastName().equals(user.getLastName())){
					u.setResponseCode(UserBean.SUCCESS_CODE);
					return u;
				} else {
					user.setResponseCode(UserBean.ERROR_CODE);
				}
			} catch (NotFoundException e) {
				user.setResponseCode(UserBean.ERROR_CODE);
			}
		}
		return user;
	}

	public UserBean create(UserBean user) {
		if (Constants.MOCK_DATA) {
			System.out.println("Konto założone, login: " + user.getFirstName()
					+ " password: " + user.getLastName());
			user.setResponseCode(UserBean.SUCCESS_CODE);
		} else {
			ObjectifyFactory fact = new ObjectifyFactory();
			fact.register(UserBean.class);
			Objectify ofy = fact.begin();
			try {
				ofy.get(UserBean.class, user.getFirstName());
				user.setResponseCode(UserBean.ERROR_CODE);
			} catch (NotFoundException e) {
				ofy.put(user);
				user.setResponseCode(UserBean.SUCCESS_CODE);
			}
		}
		return user;
	}

	public List<UserBean> getUserBeanArrayList(UserBean user) {
		List<UserBean> userBeans = new ArrayList<UserBean>();
		if (Constants.MOCK_DATA) {
			UserBean userBean = new UserBean();
			userBean.setId((long) 1);
			userBean.setFirstName("first name 1");
			userBean.setLastName("last name 1");
			userBeans.add(userBean);
			UserBean userBean2 = new UserBean();
			userBean2.setId((long) 2);
			userBean2.setFirstName("first name 2");
			userBean2.setLastName("last name 2");
			userBeans.add(userBean2);
		} else {
			ObjectifyFactory fact = new ObjectifyFactory();
			fact.register(UserBean.class);
			Objectify ofy = fact.begin();
			Query<UserBean> q = ofy.query(UserBean.class).filter("id >", 0);
			userBeans = q.list();
		}
		return userBeans;
	}
}
