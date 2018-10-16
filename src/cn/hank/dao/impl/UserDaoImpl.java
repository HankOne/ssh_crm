package cn.hank.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.hank.dao.UserDao;
import cn.hank.domain.User;

//hibernateDaoSupport为Dao注入sessionFactory
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public User getByUserCode(String usercode) {
		//HQL
		/*return getHibernateTemplate().execute(new HibernateCallback<User>() {
			@Override
			public User doInHibernate(Session session) throws HibernateException {
				String hql="from User where user_code = ? ";
				Query query = session.createQuery(hql);
				query.setParameter(0, usercode);
				User u = (User) query.uniqueResult();
				return u;
			}
		});*/
		
		//criteria
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("user_code", usercode));
		List<User> list = (List<User>) getHibernateTemplate().findByCriteria(dc);
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}else {
			return null;
		}
		
		
	}

	@Override
	public void save(User u) {
		// TODO Auto-generated method stub
		System.out.println("保存用户");
	}

}
