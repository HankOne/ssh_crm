package cn.hank.web.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.hank.domain.BaseDict;
import cn.hank.service.BaseDictService;
import net.sf.json.JSONArray;

public class BaseDictAction extends ActionSupport {

	private String dict_type_code;
	private BaseDictService baseDictService;

	@Override
	public String execute() throws Exception {
		
		// 调用Service根据typecode获得数据字典对象list
		List<BaseDict> list = baseDictService.getListByTypeCode(dict_type_code);
		// 将list转换为json格式
		String json = JSONArray.fromObject(list).toString();
		// 将json发送给浏览器
		ServletActionContext.getResponse().setContentType("application/json;charset=utf-8");
		ServletActionContext.getResponse().getWriter().write(json);
		// 告诉Struts不需要进行结果处理
		return null;
	}

	public String getDict_type_code() {
		return dict_type_code;
	}

	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}

	public BaseDictService getBaseDictService() {
		return baseDictService;
	}

	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}

}
