package user.zc.spider.process;



import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import user.zc.spider.Page;
import user.zc.spider.Site;
import user.zc.spider.Spider;
import user.zc.spider.listener.SpringContextHolder;
import user.zc.spider.pipeline.DoubanMoviePipeline;
import user.zc.spider.processor.PageProcessor;
import user.zc.spider.selector.Html;
import user.zc.spider.selector.JsonPathSelector;
import user.zc.spider.service.DoubanMovieService;

/**
 * @author 410775541@qq.com <br>
 * @since 0.5.1
 */
public class DoubanProcessor implements PageProcessor {
	private static final String LIST_URL = "https://movie.douban.com/j/search_subjects";
	private static final String movieurl = "https://movie.douban.com/subject/";
	List<String> relativeUrl  = new ArrayList<String>();
	Pattern p=Pattern.compile("^[^\\d]*(\\d+)[^\\d]*$");
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
    public DoubanProcessor(){
    	doubanMovieService  = SpringContextHolder.getBean("doubanMovieService");
    }
    @Override
    public void process(Page page) {
    	/*if(index<10)
    		relativeUrl.add(url+"&page_start="+(index++*20));
    	page.addTargetRequests(relativeUrl);*/
    	/*if(hassrc){
    		relativeUrl.add(url+"&page_start="+(index++*20));
        	page.addTargetRequests(relativeUrl);
    	}*/
    	
    	if (page.getUrl().regex(LIST_URL).match()) {
    		List<String> list = new JsonPathSelector("$.subjects[*].id").selectList(page.getRawText());
        	for(String id :list){
        		if(doubanMovieService.get((movieurl+id).hashCode())==null){
        			count++;
        			page.addTargetRequest(movieurl+id);
        		}
        	}
    	}else{
    		String answers =  page.getHtml().xpath("//div[@id='wrapper']/div[@id='content']").get();
    		page.putField("movie_id", page.getUrl().toString());
    		page.putField("title", new Html(answers).xpath("//h1/span[1]/text()"));
    		page.putField("release_date", new Html(answers).xpath("//h1/span[2]/text()").toString().substring(1, 5));
    		page.putField("movie_pic_path", new Html(answers).xpath("//div[@id='mainpic']/a/img/@src"));
    		String answersmain =  page.getHtml().xpath("//div[@id='wrapper']/div[@id='content']//div[@id='info']").get();
    		page.putField("direct", new Html(answersmain).xpath("//span[1]/span[2]/a/text()").all());
    		page.putField("scriptwriter", new Html(answersmain).xpath("//span[2]/span[@class='attrs']/a/text()").all());
    		page.putField("main_performer", new Html(answersmain).xpath("//span[@class='actor']/span[@class='attrs']//a/text()").all());
    		String film_length_temp =  new Html(answersmain).xpath("//span[@property='v:runtime']/text()").toString();
    		Matcher mc  = null;
    		try{
	   			
	   			mc  = p.matcher(film_length_temp);
	   		}catch(NullPointerException e){
	   			e.printStackTrace();
	   			System.out.println(film_length_temp);
	   		}
	   		while(mc.find()){
	   			page.putField("film_length",mc.group(1)); 
	   		}
    		page.putField("type", new Html(answersmain).xpath("//span[@property='v:genre']/text()").all());
    		String answersleft =  page.getHtml().xpath("//div[@id='wrapper']/div[@id='content']//div[@id='interest_sectl']").get();
    		page.putField("rate", new Html(answersleft).xpath("//div/div/strong[@property='v:average']/text()"));
    		page.putField("rating_people", new Html(answersleft).xpath("//div/div//a[@class='rating_people']/span/text()"));
    	}
    	
    	/*for(String str : list){
    		page.putField("id", new JsonPathSelector("$.id").select(str));
    		page.putField("rate", new JsonPathSelector("$.rate").select(str));
        	page.putField("title", new JsonPathSelector("$.title").select(str));
        	page.putField("url", new JsonPathSelector("$.url").select(str));
        	page.putField("is_new", new JsonPathSelector("$.is_new").select(str));
        	page.putField("cover", new JsonPathSelector("$.cover").select(str));
    	}*/
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new DoubanProcessor()).
                addUrl("https://movie.douban.com/j/search_subjects?type=movie&tag=%E7%BB%8F%E5%85%B8&sort=recommend&page_limit=500").
        		addPipeline(new DoubanMoviePipeline()).
                thread(5).
                run();
    }
}
