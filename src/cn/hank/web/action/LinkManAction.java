package cn.hank.web.action;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.hank.domain.LinkMan;
import cn.hank.service.LinkManService;
import cn.hank.utils.PageBean;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan> {

	private LinkMan linkMan = new LinkMan();

	private LinkManService lms;

	private Integer currentPage;
	private Integer pageSize;
	
	public String delete() {
		lms.delete(linkMan.getLkm_id());
		return "toList";
	}

	public String list() throws Exception {
		// 封装离线查询对象
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		// 判断并封装参数
		if (StringUtils.isNotBlank(linkMan.getLkm_name())) {
			dc.add(Restrictions.eq("lkm_name", "%" + linkMan.getLkm_name() + "%"));
		}
		if (linkMan.getCustomer() != null && linkMan.getCust_id() != null) {
			dc.add(Restrictions.eq("customer.cust_id", linkMan.getCustomer().getCust_id()));
		}

		// 调用Service查询分页数据(PageBean)
		PageBean pd = lms.getPageaBean(dc, currentPage, pageSize);
		ActionContext.getContext().put("pageBean", pd);
		return "list";
	}

	public String toEdit() throws Exception {
		//1.查询lkm_id
		LinkMan lm=lms.getById(linkMan.getLkm_id());
		//2.将查询到的linkMan放到request域中,转发到添加页面
		ActionContext.getContext().put("linkMan", lm);
		return "add";
	}
	
	public String add() throws Exception {
		
		lms.saveOrUpdate(linkMan);
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

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
}
