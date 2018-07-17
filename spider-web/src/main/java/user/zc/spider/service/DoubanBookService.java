package user.zc.spider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.zc.spider.dao.DoubanBookMapper;
import user.zc.spider.entity.DoubanBook;

/**
 * 创建时间：2015-1-27 下午5:22:59
 * @author zhouchuang
 * @version 2.2
 */
@Service("doubanBookService")
public class DoubanBookService {

	@Autowired
	private DoubanBookMapper doubanBookMapper;


	public int insert(DoubanBook doubanBook) {
		int insert = 0;
		try{
			insert = doubanBookMapper.insert(doubanBook);
		}catch(Exception e){
			System.out.println(doubanBook.getTitle()+"已经插入了");
		}
		return insert;
	}


}
