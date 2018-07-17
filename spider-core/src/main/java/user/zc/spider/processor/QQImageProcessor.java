package user.zc.spider.processor;



import java.util.List;

import user.zc.spider.Page;
import user.zc.spider.Site;
import user.zc.spider.Spider;
import user.zc.spider.pipeline.ConsolePipeline;
import user.zc.spider.pipeline.ImagePipeline;
import user.zc.spider.processor.PageProcessor;
import user.zc.spider.selector.Html;

/**
 * @author 410775541@qq.com <br>
 * @since 0.5.1
 */
public class QQImageProcessor implements PageProcessor {

	private int index = 1;
    private Site site = Site.me().setCycleRetryTimes(5).setRetryTimes(5).setSleepTime(500).setTimeOut(3 * 60 * 1000)
    		.setDomain("user.qzone.qq.com")
            .setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:38.0) Gecko/20100101 Firefox/38.0")
            .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
            .addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
            .addHeader("Referer", "http://user.qzone.qq.com/635659050/myhome/friends")
            .setCharset("UTF-8")
            .addCookie("blabla","dynamic")
            .addCookie("p_uin","o0635659050")
            .addCookie("uin","o0635659050")
            .addCookie("p_skey","zOYHFhKlHkg1tGgL0EjlZFRqIuJwINzMDHu9Tv51HhU_")
            .addCookie("pt4_token","9VfKJ3SGYkkYXaTdTK9gCcf50t0qQOHuMTd9kYJN2u0_")
            .addCookie("pgv_info","ssid=s6498048521")
            .addCookie("pgv_si","s1772736512")
            .addCookie("pgv_pvid","6612503181")
            .addCookie("qzone_check","635659050_1476204385")
            .addCookie("skey","@Hfsh5xST0");
    

    @Override
    public void process(Page page) {
        
    	
    	
    	/*List<String> answers   = page.getHtml().xpath("//img").all();
    	for(String answer : answers){
    		System.out.println(answer);
    	}*/
    	/*List<String> relativeUrl = page.getHtml().xpath("//div[@id='bottom_pager']/a/@href").all();
        page.addTargetRequests(relativeUrl);*/
    	List<String> answers =  page.getHtml().xpath("//ol[@id='mecarewho_list']/li").all();
        boolean exist = false;
        System.out.println(page.getHtml());
        for(String answer:answers){
        	page.putField("name", new Html(answer).xpath("//p[@class='info-name']/a/@title"));
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
        Spider.create(new QQImageProcessor()).
                addUrl("https://h5.qzone.qq.com/proxy/domain/r.qzone.qq.com/cgi-bin/tfriend/friend_ship_manager.cgi?uin=635659050&do=1&rd=0.1794256208642202&fupdate=1&clean=1&g_tk=587925702").
                addPipeline(new ConsolePipeline()).
                thread(5).
                run();
    }
}
