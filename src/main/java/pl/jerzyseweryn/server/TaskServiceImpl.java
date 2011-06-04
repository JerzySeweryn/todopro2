package pl.jerzyseweryn.server;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import pl.jerzyseweryn.client.service.TaskService;
import pl.jerzyseweryn.client.shared.TaskBean;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.googlecode.objectify.NotFoundException;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.Query;

public class TaskServiceImpl extends RemoteServiceServlet implements
		TaskService {

	// private AtomicInteger idGenerator = new AtomicInteger(0);

	/**
	 * 
	 */
	private static final long serialVersionUID = 5611425191519731020L;

	public TaskBean create(TaskBean task) {
		if (Constants.MOCK_DATA) {
			System.out.println("task created, title: " + task.getTitle()
					+ " addedby: " + task.getAddedby());
			task.setResponseCode(TaskBean.SUCCESS_CODE);
		} else {
			ObjectifyFactory fact = new ObjectifyFactory();
			fact.register(TaskBean.class);
			Objectify ofy = fact.begin();
			ofy.put(task);
			task.setResponseCode(TaskBean.SUCCESS_CODE);
		}
		return task;
	}
	
	public TaskBean open(TaskBean task) {
		if (Constants.MOCK_DATA) {
			System.out.println("task open, title: " + task.getTitle()
					+ " addedby: " + task.getAddedby());
			task.setResponseCode(TaskBean.SUCCESS_CODE);
		} else {
			ObjectifyFactory fact = new ObjectifyFactory();
			fact.register(TaskBean.class);
			Objectify ofy = fact.begin();
			try {
				ofy.get(TaskBean.class, task.getId());
				task.setStatus(TaskBean.STATUS_OPEN);
				ofy.put(task);
				task.setResponseCode(TaskBean.SUCCESS_CODE);
			} catch (NotFoundException e) {
				task.setResponseCode(TaskBean.ERROR_CODE);
			}
		}
		return task;
	}
	
	public TaskBean close(TaskBean task) {
		if (Constants.MOCK_DATA) {
			System.out.println("task close, title: " + task.getTitle()
					+ " addedby: " + task.getAddedby());
			task.setResponseCode(TaskBean.SUCCESS_CODE);
		} else {
			ObjectifyFactory fact = new ObjectifyFactory();
			fact.register(TaskBean.class);
			Objectify ofy = fact.begin();
			try {
				ofy.get(TaskBean.class, task.getId());
				task.setStatus(TaskBean.STATUS_CLOSE);
				ofy.put(task);
				task.setResponseCode(TaskBean.SUCCESS_CODE);
			} catch (NotFoundException e) {
				task.setResponseCode(TaskBean.ERROR_CODE);
			}
		}
		return task;
	}
	
	public TaskBean delete(TaskBean task) {
		if (Constants.MOCK_DATA) {
			System.out.println("task delete, title: " + task.getTitle()
					+ " addedby: " + task.getAddedby());
			task.setResponseCode(TaskBean.SUCCESS_CODE);
		} else {
			ObjectifyFactory fact = new ObjectifyFactory();
			fact.register(TaskBean.class);
			Objectify ofy = fact.begin();
			ofy.delete(task);
			task.setResponseCode(TaskBean.SUCCESS_CODE);
		}
		return task;
	}

	public List<TaskBean> getTaskBeanArrayList(TaskBean task) {
		List<TaskBean> taskBeans = new ArrayList<TaskBean>();
		if (Constants.MOCK_DATA) {
			TaskBean taskBean = new TaskBean();
			taskBean.setId((long) 1);
			taskBean.setTitle("title 1");
			taskBean.setAddedby("user 1");
			taskBean.setAdded(new Date());
			taskBeans.add(taskBean);
			TaskBean taskBean2 = new TaskBean();
			taskBean2.setId((long) 2);
			taskBean2.setTitle("title 2");
			taskBean2.setAddedby("user 2");
			taskBean2.setAdded(new Date());
			taskBeans.add(taskBean2);
		} else {
			ObjectifyFactory fact = new ObjectifyFactory();
			fact.register(TaskBean.class);
			Objectify ofy = fact.begin();
			Query<TaskBean> q = ofy.query(TaskBean.class).filter("addedby =", task.getAddedby());
			taskBeans = q.list();
		}
		return taskBeans;
	}
}
