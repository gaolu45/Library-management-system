package cn.test.bookms.entity;

import java.io.Serializable;

public class MsCategory implements Serializable {
    private Integer id;

    private Integer categoryId;

    private String categoryName;

    private Integer delFlg;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public Integer getDelFlg() {
        return delFlg;
    }

    public void setDelFlg(Integer delFlg) {
        this.delFlg = delFlg;
    }

	@Override
	public String toString() {
		return "MsCategory [id=" + id + ", categoryId=" + categoryId + ", categoryName=" + categoryName + ", delFlg="
				+ delFlg + "]";
	}
    
    
}