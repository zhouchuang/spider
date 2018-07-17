package user.zc.spider.dao;

import java.util.HashMap;
import java.util.List;

import user.zc.spider.entity.DoubanMovie;


public interface DoubanMovieMapper {

    int insert(DoubanMovie record);
    
    List<DoubanMovie> selectAll(HashMap<String,Object> map);
    
    List<DoubanMovie> selectTopDirectList();
    DoubanMovie selectByPrimaryKey(Integer id);
    
    void update(DoubanMovie dm);
}