package cn.hank.dao;

import java.util.List;

import cn.hank.domain.BaseDict;

public interface BaseDictDao {
	//根据类型来获得数据字典列表
	List<BaseDict> getListByTypeCode(String dict_type_code);

}
