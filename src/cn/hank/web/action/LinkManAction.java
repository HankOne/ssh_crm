package cn.hank.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.hank.domain.LinkMan;
import cn.hank.service.LinkManService;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{

	private LinkMan linkMan=new LinkMan();
	
	private LinkManService lms;
	
	public String add() throws Exception {

		lms.save(linkMan);
		return "toList";
	}

	public LinkMan getLinkMan() {
		return linkMan;
	}

	public void setLinkMan(LinkMan linkMan) {
		this.linkMan = linkMan;
	}

	public void setLms(LinkManService lms) {
		this.lms = lms;
	}

	@Override
	public LinkMan getModel() {
		// TODO Auto-generated method stub
		return linkMan;
	}
	
	
}
