package user.zc.spider.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.zc.spider.dao.DoubanMovieMapper;
import user.zc.spider.entity.DoubanMovie;
import user.zc.spider.model.UserInfo;

/**
 * 创建时间：2015-1-27 下午5:22:59
 * @author zhouchuang
 * @version 2.2
 */
@Service("doubanMovieService")
public class DoubanMovieService {

	@Autowired
	private DoubanMovieMapper doubanMovieMapper;

	public List<DoubanMovie> getList(HashMap<String,Object> map) {
		return doubanMovieMapper.selectAll(map);
	}

	public int insert(DoubanMovie doubanMovie) {
		int insert = 0;
		try{
			insert = doubanMovieMapper.insert(doubanMovie);
		}catch(Exception e){
			System.out.println(doubanMovie.getTitle()+"已经插入了");
		}
		return insert;
	}

	public DoubanMovie get(Integer id) {
		return doubanMovieMapper.selectByPrimaryKey(id);
	}
	
	public List<DoubanMovie> selectTopDirectList() {
		return doubanMovieMapper.selectTopDirectList();
	}
	
	public void update(DoubanMovie doubanMovie){
		doubanMovieMapper.update(doubanMovie);
	}

}
