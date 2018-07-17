package user.zc.spider.pipeline;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.http.annotation.ThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import user.zc.spider.ResultItems;
import user.zc.spider.Task;
import user.zc.spider.entity.DoubanBook;
import user.zc.spider.listener.SpringContextHolder;
import user.zc.spider.service.DoubanBookService;
import user.zc.spider.utils.FilePersistentBase;
import user.zc.spider.utils.ListUtils;

/**
 * Store results in files.<br>
 *
 * @author code4crafter@gmail.com <br>
 * @since 0.1.0
 */
@ThreadSafe
public class DoubanBookPipeline extends FilePersistentBase implements Pipeline {

    private Logger logger = LoggerFactory.getLogger(getClass());
    
    
    private DoubanBookService doubanBookService  ;
    
    

    /**
     * create a FilePipeline with default path"/data/webmagic/"
     */
    public DoubanBookPipeline() {
        setPath("E:\\data\\spider\\douban\\movie\\");
        doubanBookService  = SpringContextHolder.getBean("doubanBookService");
    }
    

    @Override
    public void process(ResultItems resultItems, Task task) {
    	
    	boolean bool = false;
    	List<Map> list = resultItems.get("list");
    	for(Map map : list){
    		Iterator it = map.entrySet().iterator();
    		DoubanBook dm = new DoubanBook();
        	Class clazz = dm.getClass();
    		while(it.hasNext()){
    			Map.Entry<String, Object> entry  = (Map.Entry<String, Object>)it.next();
    			Field field = null;
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
    			}catch(NullPointerException en){
    				System.out.println(field.getName()+";"+entry.getKey()+";"+entry.getValue());
    			} catch (NoSuchFieldException e1) {
    				e1.printStackTrace();
    			} catch( SecurityException | IllegalArgumentException | IllegalAccessException e){
    				e.printStackTrace();
    			}
    			bool  = true;
    		}
    		if(bool){
	    		dm.setId(dm.getTitle().hashCode());
	    		doubanBookService.insert(dm);
	    	}	
    	}
    	
    }
}
