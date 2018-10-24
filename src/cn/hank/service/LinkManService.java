package cn.hank.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.hank.domain.LinkMan;
import cn.hank.utils.PageBean;

public interface LinkManService {

	void save(LinkMan linkMan);

	PageBean getPageaBean(DetachedCriteria dc, Integer currentPage, Integer pageSize);

	LinkMan getById(Long cust_id);

}
