package cn.test.bookms.entity;

import java.io.Serializable;
import java.util.Date;

public class MsAdmin implements Serializable {
    private Integer id;

    private String adminNumber;

    private String adminPwd;

    private String adminName;

    private Date loginPreTime;

    private Integer delFlg;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAdminNumber() {
        return adminNumber;
    }

    public void setAdminNumber(String adminNumber) {
        this.adminNumber = adminNumber == null ? null : adminNumber.trim();
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd == null ? null : adminPwd.trim();
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName == null ? null : adminName.trim();
    }

    public Date getLoginPreTime() {
        return loginPreTime;
    }

    public void setLoginPreTime(Date loginPreTime) {
        this.loginPreTime = loginPreTime;
    }

    public Integer getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Integer delFlg) {
        this.delFlg = delFlg;
    }

	@Override
	public String toString() {
		return "MsAdmin [id=" + id + ", adminNumber=" + adminNumber + ", adminPwd=" + adminPwd + ", adminName="
				+ adminName + ", loginPreTime=" + loginPreTime + ", delFlg=" + delFlg + "]";
	}
    
    
}