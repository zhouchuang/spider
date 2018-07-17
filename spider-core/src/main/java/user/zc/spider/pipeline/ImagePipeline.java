package user.zc.spider.pipeline;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import org.apache.http.annotation.ThreadSafe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import user.zc.spider.ResultItems;
import user.zc.spider.Task;
import user.zc.spider.utils.FilePersistentBase;
import user.zc.spider.utils.UrlUtils;


/**
 * Store results in files.<br>
 *
 * @author code4crafter@gmail.com <br>
 * @since 0.1.0
 */
@ThreadSafe
public class ImagePipeline extends FilePersistentBase implements Pipeline {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * create a FilePipeline with default path"/data/webmagic/"
     */
    public ImagePipeline() {
        setPath("/data/webmagic/");
    }

    public ImagePipeline(String path) {
        setPath(path);
    }

    @Override
    public void process(ResultItems resultItems, Task task) {
        try {
        	for (Map.Entry<String, Object> entry : resultItems.getAll().entrySet()) {
        		String urlString  =  entry.getValue().toString();
        		if(urlString==null||"".equals(urlString)||"".equals(urlString.trim()))continue;
        		String filename  =  entry.getKey();
        		String ext = "."+ urlString.split("\\.")[urlString.split("\\.").length-1];
        		 // 构造URL  
                URL url = new URL(UrlUtils.getFullHttpRequestUrl(urlString));  
                // 打开连接  
                URLConnection con = url.openConnection();  
                //设置请求超时为5s  
                con.setConnectTimeout(5*1000);  
                // 输入流  
                InputStream is = con.getInputStream();  
              
                // 1K的数据缓冲  
                byte[] bs = new byte[1024];  
                // 读取到的数据长度  
                int len;  
                // 输出的文件流  
               File sf=new File(this.path);  
               if(!sf.exists()){  
                   sf.mkdirs();  
               }  
               OutputStream os = new FileOutputStream(sf.getPath()+"\\"+filename+ext);  
                // 开始读取  
                while ((len = is.read(bs)) != -1) {  
                  os.write(bs, 0, len);  
                }  
                // 完毕，关闭所有链接  
                os.close();  
                is.close();  
            }
        } catch (IOException e) {
            logger.warn("write file error", e);
        }
    }
}
