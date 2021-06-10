package cn.test.bookms.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.test.bookms.entity.MsAdmin;
import cn.test.bookms.mapper.MsAdminMapper;
import cn.test.bookms.service.MsAdminService;



@Service("msAdminService")
public class MsAdminServiceImpl implements MsAdminService{

	@Autowired
	private MsAdminMapper msAdminMapper;
	

	public MsAdmin selectByPrimaryKey(Integer id) {
		return msAdminMapper.selectByPrimaryKey(id);
	}

	public MsAdmin selectAdmin(Map<String,String> map) {
		return msAdminMapper.selectAdmin(map);
	}

}
