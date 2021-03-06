package cn.test.bookms.service;


import java.util.List;

import cn.test.bookms.entity.MsBook;
import cn.test.bookms.entity.PageBean;

public interface MsBookService {

	/**
	 * 添加书籍
	 * @param book
	 */
	void insertBook(MsBook book);
	
	/**
	 * 通过主键下架图书(逻辑删除)
	 * @param id
	 * @return
	 */
    int deleteByPrimaryKey(Integer id);
	
	/**
	 * 根据id查询一本书
	 */
	MsBook selectByID(int id);
	
	/**
	 * 更新书籍
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(MsBook record);
	
	
	
	/**
	 * 能查询某个字段并分页显示所有未下架书籍
	 * 
	 */
	PageBean<MsBook> selectByPage(String title,String author,int currentPage);
	
	/**
	 * 查询所有未下架的书
	 * @return
	 */
	int selectCount();
	
	
    /**
     * 最近上架的图书(最近2个月)
     */
    List<MsBook>  selectNewBook();
    
    
    /**
     * 所有下架的图书
     */
    List<MsBook>  selectBookDel();
    
    
    
    /**
     * 重新上架图书
     */
    int updateBackBook(int id);
    
    
    /**
     * 彻底删除图书
     */
    int deleteBookReal(int id);
}
