package cn.hank.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.hank.dao.LinkManDao;
import cn.hank.domain.LinkMan;
import cn.hank.service.LinkManService;
import cn.hank.utils.PageBean;

public class LinkManServiceImpl implements LinkManService {

	private LinkManDao lmd;
	
	@Override
	public void save(LinkMan linkMan) {
		lmd.save(linkMan);
	}

	public void setLmd(LinkManDao lmd) {
		this.lmd = lmd;
	}

	@Override
	public PageBean getPageaBean(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		//调用dao查询总记录数
		Integer totalCount=lmd.getTotalCount(dc);
		//创建PageBean
		PageBean pb=new PageBean(currentPage,totalCount,pageSize);
		//调用dao查询分页数据列表
		System.out.println(pb);
		List<LinkMan> list=lmd.getPageList(dc, pb.getStart(), pb.getPageSize());
		pb.setList(list);
		return pb;
	}

	@Override
	public LinkMan getById(Long cust_id) {
		lmd.getById(cust_id);
		return null;
	}

	
}
