package cn.hank.dao;

import cn.hank.domain.User;

public interface UserDao {

	//根据登录名查询user对象
	User getByUserCode(String usercode);
	//保存用户
	void save(User u);
	
}
