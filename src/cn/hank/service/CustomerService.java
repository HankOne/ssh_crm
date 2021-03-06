package cn.hank.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.hank.domain.Customer;
import cn.hank.utils.PageBean;

public interface CustomerService {
	//分页业务方法
	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);
	//保存客户方法
	void save(Customer customer);
	//根据id获得客户对象
	Customer getById(Long cust_id);
	void delete(Long cust_id);

}
