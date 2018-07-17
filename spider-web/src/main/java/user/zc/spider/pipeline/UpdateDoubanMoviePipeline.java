package user.zc.spider.pipeline;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.annotation.ThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.zc.spider.ResultItems;
import user.zc.spider.Task;
import user.zc.spider.entity.DoubanMovie;
import user.zc.spider.listener.SpringContextHolder;
import user.zc.spider.service.DoubanMovieService;
import user.zc.spider.utils.FilePersistentBase;
import user.zc.spider.utils.ListUtils;

/**
 * Store results in files.<br>
 *
 * @author code4crafter@gmail.com <br>
 * @since 0.1.0
 */
@ThreadSafe
public class UpdateDoubanMoviePipeline extends FilePersistentBase implements Pipeline {

    private Logger logger = LoggerFactory.getLogger(getClass());
    
    
    private DoubanMovieService doubanMovieService  ;
    
    

    /**
     * create a FilePipeline with default path"/data/webmagic/"
     */
    public UpdateDoubanMoviePipeline() {
        setPath("E:\\data\\spider\\douban\\movie\\");
        doubanMovieService  = SpringContextHolder.getBean("doubanMovieService");
    }
    

    @Override
    public void process(ResultItems resultItems, Task task) {
    	DoubanMovie dm = new DoubanMovie();
    	Class clazz = dm.getClass();
    	boolean bool = false;
    	for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
			Field field;
			try {
				field = clazz.getDeclaredField(entry.getKey().trim());
				int mod = field.getModifiers();    
	            if(Modifier.isStatic(mod) || Modifier.isFinal(mod)){    
	                continue;    
	            }    
	            field.setAccessible(true);
				if(entry.getValue() instanceof List){
					field.set(dm, ListUtils.join((List<String>)entry.getValue(), ","));
				}else if(field.getGenericType().toString().contains("Float") ){
					field.set(dm, Float.parseFloat(entry.getValue().toString().trim()));
				}else if(field.getGenericType().toString().contains("Integer") ){
					field.set(dm, Integer.parseInt(entry.getValue().toString().trim()));
				}else{
					field.set(dm, entry.getValue().toString().trim());
				}
			} catch (NoSuchFieldException e1) {
				e1.printStackTrace();
			} catch( SecurityException | IllegalArgumentException | IllegalAccessException e){
				e.printStackTrace();
			}
			bool  = true;
        }
    	if(bool){
    		dm.setId(dm.getMovie_id().hashCode());
    		doubanMovieService.update(dm);
    	}
    }
}
