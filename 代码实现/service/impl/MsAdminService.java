package cn.test.bookms.service;

import java.util.Map;


import cn.test.bookms.entity.MsAdmin;



public interface MsAdminService {

	/**
	 * 通过用户名密码登
	 * 登录(Map 放入登录号和密码)
	 * @param adminNumber
	 * @param adminPwd
	 * @return
	 */
	MsAdmin selectAdmin(Map<String,String> map);
	
	/**
	 * 
	 */
	MsAdmin selectByPrimaryKey(Integer id);
}
