package pl.jerzyseweryn.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import pl.jerzyseweryn.client.shared.TaskBean;

@RemoteServiceRelativePath("taskService")
public interface TaskService extends RemoteService {
	TaskBean create(TaskBean task);
	TaskBean delete(TaskBean task);
	TaskBean open(TaskBean task);
	TaskBean close(TaskBean task);
	List<TaskBean> getTaskBeanArrayList(TaskBean task);
}
