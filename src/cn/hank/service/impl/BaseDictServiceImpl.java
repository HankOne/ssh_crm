package cn.hank.service.impl;

import java.util.List;

import cn.hank.dao.BaseDictDao;
import cn.hank.domain.BaseDict;
import cn.hank.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService {

	private BaseDictDao bdd;
	
	@Override
	public List<BaseDict> getListByTypeCode(String dict_type_code) {
		return bdd.getListByTypeCode(dict_type_code);
	}

	public void setBdd(BaseDictDao bdd) {
		this.bdd = bdd;
	}
	
	
}
