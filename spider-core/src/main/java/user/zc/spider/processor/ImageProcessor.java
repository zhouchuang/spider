package user.zc.spider.processor;



import java.util.List;

import user.zc.spider.Page;
import user.zc.spider.Site;
import user.zc.spider.Spider;
import user.zc.spider.pipeline.ImagePipeline;
import user.zc.spider.processor.PageProcessor;
import user.zc.spider.selector.Html;

/**
 * @author 410775541@qq.com <br>
 * @since 0.5.1
 */
public class ImageProcessor implements PageProcessor {

	private int index = 1;
    private Site site = Site.me().setCycleRetryTimes(5).setRetryTimes(5).setSleepTime(500).setTimeOut(3 * 60 * 1000)
            .setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:38.0) Gecko/20100101 Firefox/38.0")
            .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
            .addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
            .setCharset("UTF-8");



    @Override
    public void process(Page page) {
        
    	
    	
    	/*List<String> answers   = page.getHtml().xpath("//img").all();
    	for(String answer : answers){
    		System.out.println(answer);
    	}*/
    	List<String> relativeUrl = page.getHtml().xpath("//div[@id='bottom_pager']/a/@href").all();
        page.addTargetRequests(relativeUrl);
    	List<String> answers =  page.getHtml().xpath("//div[@class='res-img']/div[@class='img-block']").all();
        boolean exist = false;
        for(String answer:answers){
            page.putField(index++ + "", new Html(answer).xpath("//img[@class='search-loading']/@src2"));
            exist = true;
        }
        if(!exist){
            page.setSkip(true);
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new ImageProcessor()).
                addUrl("http://search.suning.com/Iphone7/").
                addPipeline(new ImagePipeline("E:\\webmagic\\")).
                thread(5).
                run();
    }
}
