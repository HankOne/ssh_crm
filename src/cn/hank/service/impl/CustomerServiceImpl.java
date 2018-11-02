package cn.hank.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.hank.dao.CustomerDao;
import cn.hank.domain.Customer;
import cn.hank.service.CustomerService;
import cn.hank.utils.PageBean;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDao cd;
	
	@Override
	public PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//查询总记录数
		Integer totalCount=cd.getTotalCount(dc);
		System.out.println("记录数为"+totalCount);
		//创建PageBean对象
		PageBean pd=new PageBean(currentPage, totalCount, pageSize);
		//查询list分页数据
		List<Customer> list=cd.getPageList(dc,pd.getStart(),pd.getPageSize());
		pd.setList(list);
		return pd;
	}

	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}

	@Override
	public void save(Customer customer) {
		cd.saveOrUpdate(customer);
		
		
	}

	@Override
	public Customer getById(Long cust_id) {
		return cd.getById(cust_id);
	}
	
	

}
