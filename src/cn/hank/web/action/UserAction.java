package cn.hank.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.hank.domain.User;
import cn.hank.service.UserService;

//Struts模型模型驱动
public class UserAction extends ActionSupport implements ModelDriven<User> {

	private UserService userService;
	private User user = new User();

	public String login() throws Exception {

		User u = userService.getUserByCodePassword(user);
		ActionContext.getContext().getSession().put("user", u);
		// 重定向到主页
		return "toHome";
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public User getModel() {
		return user;
	}

}
