package cn.hank.service.impl;

import cn.hank.dao.LinkManDao;
import cn.hank.domain.LinkMan;
import cn.hank.service.LinkManService;

public class LinkManServiceImpl implements LinkManService {

	private LinkManDao lmd;
	
	@Override
	public void save(LinkMan linkMan) {
		lmd.save(linkMan);
	}

	public void setLmd(LinkManDao lmd) {
		this.lmd = lmd;
	}

	
}
