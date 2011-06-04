package pl.jerzyseweryn.client.service;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import pl.jerzyseweryn.client.shared.UserBean;

@RemoteServiceRelativePath("userService")
public interface UserService extends RemoteService {
	UserBean create(UserBean user);
	UserBean login(UserBean user);
	List<UserBean> getUserBeanArrayList(UserBean user);
}
