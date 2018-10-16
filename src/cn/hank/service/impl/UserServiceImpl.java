package cn.hank.service.impl;

import cn.hank.dao.UserDao;
import cn.hank.domain.User;
import cn.hank.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao ud;
	
	@Override
	public User getUserByCodePassword(User u) {
		User existU = ud.getByUserCode(u.getUser_code());
		if(existU==null) {
			throw new RuntimeException("用户名不存在");
		}
		if(!existU.getUser_password().equals(u.getUser_password())){
			throw new RuntimeException("密码错误！");
		}
		return existU;
	}

	@Override
	public void saveUser(User u) {
		ud.save(u);
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}
	

}
