package cn.hank.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.hank.utils.PageBean;

public interface CustomerService {

	PageBean getPageBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);


}
