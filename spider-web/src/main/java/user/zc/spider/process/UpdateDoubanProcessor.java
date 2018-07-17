package user.zc.spider.process;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import user.zc.spider.Page;
import user.zc.spider.Site;
import user.zc.spider.Spider;
import user.zc.spider.entity.DoubanMovie;
import user.zc.spider.listener.SpringContextHolder;
import user.zc.spider.pipeline.ConsolePipeline;
import user.zc.spider.processor.PageProcessor;
import user.zc.spider.selector.Html;
import user.zc.spider.service.DoubanMovieService;

/**
 * @author 410775541@qq.com <br>
 * @since 0.5.1
 */
public class UpdateDoubanProcessor implements PageProcessor {
	private static final String LIST_URL = "https://movie.douban.com/j/search_subjects";
	private static final String movieurl = "https://movie.douban.com/subject/";
	List<String> relativeUrl  = new ArrayList<String>();
	Pattern p=Pattern.compile("^[^\\d]*(\\d+)[^\\d]*$");
	private HttpServletRequest request;
	private DoubanMovieService doubanMovieService ;
	private int count = 0;
    private Site site = Site.me().setCycleRetryTimes(5).setRetryTimes(5).setSleepTime(2000).setTimeOut(3 * 60 * 1000)
    		.setDomain("movie.douban.com")
            .setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36")
            .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
            .addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
            .addCookie("bid", "p3HfFvDoPS4")
            .addCookie("gr_user_id","f0f818a0-aa58-4e5e-9a72-6606f76b3bc0")
            .addCookie("viewed","26821461")
            .addCookie("as","https://developers.douban.com/apikey/")
            .setCharset("UTF-8");
    
    public int getCount(){
    	return count;
    }
    public UpdateDoubanProcessor(HttpServletRequest request){
    	this.request = request;
    	doubanMovieService  = SpringContextHolder.getBean("doubanMovieService");
    }
    @Override
    public void process(Page page) {
    	
    	if (page.getUrl().regex(LIST_URL).match()) {
    		List<DoubanMovie> list = doubanMovieService.getList(new HashMap());
    		for(DoubanMovie dm : list){
    			count++;
    			request.getSession().setAttribute(request.getParameter("taskName"),count );
    			page.addTargetRequest(dm.getMovie_id()+"/");
    		}
    	}else{
    		String answers =  page.getHtml().xpath("//div[@id='wrapper']/div[@id='content']").get();
    		page.putField("movie_id", page.getUrl().toString().substring(0, page.getUrl().get().length()-1));
    		page.putField("movie_pic_path", new Html(answers).xpath("//div[@id='mainpic']/a/img/@src"));
    		String answersleft =  page.getHtml().xpath("//div[@id='wrapper']/div[@id='content']//div[@id='interest_sectl']").get();
    		page.putField("rate", new Html(answersleft).xpath("//div/div/strong[@property='v:average']/text()"));
    		page.putField("rating_people", new Html(answersleft).xpath("//div/div//a[@class='rating_people']/span/text()"));
    		page.putField("synopsis", new Html(answers).xpath("//div[@id='link-report']/span//text()"));
    	}
    	
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
       /* Spider.create(new UpdateDoubanProcessor()).
                addUrl("https://movie.douban.com/j/search_subjects?type=movie&tag=%E7%BB%8F%E5%85%B8&sort=recommend&page_limit=500").
                //addUrl("https://movie.douban.com/j/search_subjects?type=movie&tag=%E6%9C%80%E6%96%B0&page_limit=500").
        		addPipeline(new ConsolePipeline()).
                thread(5).
                run();*/
    }
}
