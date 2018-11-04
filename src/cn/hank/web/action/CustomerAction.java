package cn.hank.web.action;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.hank.domain.Customer;
import cn.hank.service.CustomerService;
import cn.hank.utils.PageBean;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	private CustomerService cs;

	// 上传文件会自动封装到file对象
	// 在后台提供一个与前台input type=file组件name相同的属性
	private File photo;
	// 在提交键名后加上固定后缀FileName，文件会自动封装到属性中
	private String photoFileName;
	// 在提交键名后加上固定后缀ContentType，文件MIME类型会自动封装到属性中
	private String photoContentType;

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	private Customer customer = new Customer();
	private Integer currentPage;
	private Integer pageSize;

	public String list() throws Exception {

		DetachedCriteria dc = DetachedCriteria.forClass(Customer.class);
		if (StringUtils.isNotBlank(customer.getCust_name())) {
			dc.add(Restrictions.like("cust_name", "%" + customer.getCust_name() + "%"));
		}
		PageBean pb = cs.getPageBean(dc, currentPage, pageSize);
		ActionContext.getContext().put("pageBean", pb);
		return "list";

	}

	public String add() throws Exception {
		if (photo != null) {
			System.out.println("文件名称：" + photoFileName);
			System.out.println("文件类型：" + photoContentType);
			// 将文件保存到指定位置
			photo.renameTo(new File("D:/JAVAEE_Code/ssh_crm/upload/" + photoFileName + ".jpg"));
		}
		cs.save(customer);
		// 重定向到客户列表
		return "toList";
	}
	
	
	public String toEdit() throws Exception {
		//调用Service根据id获得用户
		Customer c=cs.getById(customer.getCust_id());
		//将客户放置到request域，并转发到编辑页面
		ActionContext.getContext().put("customer", c);
		return "edit";
	}
	
	public String delete(){
		cs.delete(customer.getCust_id());
		return "toList";
	}

	public void setCs(CustomerService cs) {
		this.cs = cs;
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

	@Override
	public Customer getModel() {
		return customer;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

}
