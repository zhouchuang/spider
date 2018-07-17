package user.zc.spider.processor;



import java.util.ArrayList;
import java.util.List;

import user.zc.spider.Page;
import user.zc.spider.Site;
import user.zc.spider.Spider;
import user.zc.spider.pipeline.ConsolePipeline;
import user.zc.spider.selector.Html;
import user.zc.spider.selector.JsonPathSelector;

/**
 * @author 410775541@qq.com <br>
 * @since 0.5.1
 */
public class DoubanProcessor implements PageProcessor {
	private static final String LIST_URL = "https://movie.douban.com/j/search_subjects";
	private static final String movieurl = "https://movie.douban.com/subject/";
	List<String> relativeUrl  = new ArrayList<String>();
    private Site site = Site.me().setCycleRetryTimes(5).setRetryTimes(5).setSleepTime(500).setTimeOut(3 * 60 * 1000)
    		.setDomain("movie.douban.com")
            .setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36")
            .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
            .addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
            .setCharset("UTF-8");
    
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
        		page.addTargetRequest(movieurl+id);
        	}
    	}else{
    		String answers =  page.getHtml().xpath("//div[@id='wrapper']/div[@id='content']").get();
    		page.putField("title", new Html(answers).xpath("//h1/span[1]/text()"));
    		page.putField("release_date", new Html(answers).xpath("//h1/span[2]/text()"));
    		page.putField("movie_pic_path", new Html(answers).xpath("//div[@id='mainpic']/a/@href"));
    		String answersmain =  page.getHtml().xpath("//div[@id='wrapper']/div[@id='content']//div[@id='info']").get();
    		page.putField("direct", new Html(answersmain).xpath("//span[1]/span[2]/a/text()").all());
    		page.putField("scriptwriter", new Html(answersmain).xpath("//span[2]/span[@class='attrs']/a/text()").all());
    		page.putField("main_performer", new Html(answersmain).xpath("//span[@class='actor']/span[@class='attrs']//a/text()").all());
    		page.putField("film_length", new Html(answersmain).xpath("//span[@property='v:runtime']/text()"));
    		page.putField("type", new Html(answersmain).xpath("//span[@property='v:genre']/text()").all());
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
                addUrl("https://movie.douban.com/j/search_subjects?type=movie&tag=%E7%83%AD%E9%97%A8&sort=recommend&page_limit=20").
                //addUrl("https://movie.douban.com/j/search_subjects?type=movie&tag=%E6%9C%80%E6%96%B0&page_limit=500").
        		addPipeline(new ConsolePipeline()).
                thread(5).
                run();
    }
}
