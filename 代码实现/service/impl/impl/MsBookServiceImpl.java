package cn.test.bookms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.test.bookms.entity.MsBook;
import cn.test.bookms.entity.PageBean;
import cn.test.bookms.mapper.MsBookMapper;
import cn.test.bookms.service.MsBookService;
import cn.test.bookms.util.Message;

@Service("msBookService")
public class MsBookServiceImpl implements MsBookService {

	@Autowired
	private MsBookMapper msBookMapper;
	
	
	public void insertBook(MsBook book) {
		msBookMapper.insert(book);
	}

	
	/**
	 * 分页显示书籍
	 */
	public PageBean<MsBook> selectByPage(String title,String author,int currentPage) {
		HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<MsBook> pageBean = new PageBean<MsBook>();
		
        //设置当前页数
        pageBean.setCurrPage(currentPage);
        
        //设置每页显示的数据
        int pageSize = Message.PAGE_SIZE;
        pageBean.setPageSize(pageSize);
        
        //设置总页数
        int totalCount =msBookMapper.selectCount();
        pageBean.setTotalCount(totalCount);
		
        //设置总页数
        double tc = totalCount;
        Double num = Math.ceil(tc/pageSize);
        pageBean.setTotalPage(num.intValue());
        
        map.put("start", (currentPage-1)*pageSize);
        map.put("size", pageBean.getPageSize());
        map.put("author", author);
        map.put("title", title);
        
        //封装每页显示的数据
        List<MsBook> bookList = msBookMapper.selectByPage(map);
        pageBean.setLists(bookList);
        
		return pageBean;
	}


	public int selectCount() {
		return msBookMapper.selectCount();
	}


	public MsBook selectByID(int id) {
		return msBookMapper.selectByPrimaryKey(id);
	}
	
	public int updateByPrimaryKeySelective(MsBook record) {
		return msBookMapper.updateByPrimaryKeySelective(record);
	}


	public int deleteByPrimaryKey(Integer id) {
		return msBookMapper.deleteByPrimaryKey(id);
	}


	public List<MsBook> selectNewBook() {
		return msBookMapper.selectNewBook();
	}


	public List<MsBook> selectBookDel() {
		return msBookMapper.selectBookDel();
	}


	public int updateBackBook(int id) {
		return msBookMapper.updateBackBook(id);
	}


	public int deleteBookReal(int id) {
		return msBookMapper.deleteBookReal(id);
	}



}
