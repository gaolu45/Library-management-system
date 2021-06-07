package cn.test.bookms.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.test.bookms.entity.MsAdmin;
import cn.test.bookms.service.MsAdminService;
import cn.test.bookms.util.Message;




@Controller
public class LoginController {

	@Autowired
	private MsAdminService msAdminService;
	
	@RequestMapping(value = "/login")
	public String toLogin() {
		return "login";
	}
	
	@RequestMapping(value = "/sellManage")
	public String tosellManage() {
		return "sellManage";
	}

	@RequestMapping(value = "/adminLogin")
	public String adminLogin(String adminNumber,String adminPwd,HttpSession httpSession,HttpSession httpSession2) {
		Map<String,String> map = new HashMap<String,String>();
		map.put("adminNumber", adminNumber);
		map.put("adminPwd", adminPwd);
		MsAdmin msAdmin = msAdminService.selectAdmin(map);
		if(msAdmin != null) {
			httpSession.setAttribute("msAdmin", msAdmin);
			//httpSession.setMaxInactiveInterval(1800);  //默认存在半个小时  设置回话存在时长 秒单位
			httpSession.setAttribute("imgPath", Message.IMG_PATH);
			return "index";
		}else {
			httpSession2.setAttribute("Login_error", Message.LOGIN_FAILED_MSG);
			httpSession2.setMaxInactiveInterval(1);   //设置该消息存在一秒，显示后下次访问页面即消失
			return "redirect:/login";
		}
	}
	
	/**
	 * 安全退出
	 * @param httpSession
	 * @return
	 */
	@RequestMapping(value = "/adminLogout")
	public String adminLogout(HttpSession httpSession) {
		MsAdmin msAdmin = (MsAdmin) httpSession.getAttribute("msAdmin");  //从sesion中获取MsAdmin对象
		if(msAdmin !=null) {  
			httpSession.removeAttribute("msAdmin");  //移除
			return "redirect:/login";   //重定向到登登录界面
		}
		return "redirect:/login";
	}
	
}
