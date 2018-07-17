package user.zc.spider.process;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import user.zc.spider.Page;
import user.zc.spider.Site;
import user.zc.spider.Spider;
import user.zc.spider.listener.SpringContextHolder;
import user.zc.spider.pipeline.ConsolePipeline;
import user.zc.spider.processor.PageProcessor;
import user.zc.spider.selector.Html;
import user.zc.spider.service.DoubanBookService;

/**
 * @author 410775541@qq.com <br>
 * @since 0.5.1
 */
public class DoubanBookProcessor implements PageProcessor {
	private static final String pageurl = "https://book.douban.com/subject";
	private int count = 0;
	private Site site = Site.me().setCycleRetryTimes(5).setRetryTimes(5).setSleepTime(2000).setTimeOut(3 * 60 * 1000)
			.setDomain("movie.douban.com")
			.setUserAgent(
					"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36")
			.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
			.addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3").addCookie("bid", "p3HfFvDoPS4")
			.addCookie("gr_user_id", "f0f818a0-aa58-4e5e-9a72-6606f76b3bc0").addCookie("viewed", "26821461")
			.addCookie("as", "https://developers.douban.com/apikey/").setCharset("UTF-8");

	public int getCount() {
		return count;
	}
	private DoubanBookService doubanBookService ;
	public DoubanBookProcessor() {
		//doubanBookService  = SpringContextHolder.getBean("doubanBookService");
	}

	@Override
	public void process(Page page) {

		List<String> relativepageUrl = page.getHtml().xpath("//div[@class='paginator']/a/@href").all();
		page.addTargetRequests(relativepageUrl);
		
		
		List<String> contexts = page.getHtml().xpath("//div[@id='subject_list']//li[@class='subject-item']").all();
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();

		for (String context : contexts) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("book_pic_path", new Html(context).xpath("//a[@class='nbg']//img/@src").toString());
			map.put("title", new Html(context).xpath("//div[@class='info']/h2/a/@title").toString());
			map.put("nationality", new Html(context).xpath("//div[@class='info']/div[@class='pub']/text()").toString());
			map.put("rate",
					new Html(context)
							.xpath("//div[@class='info']/div[@class='star clearfix']/span[@class='rating_nums']/text()")
							.toString());
			String rp = new Html(context)
					.xpath("//div[@class='info']/div[@class='star clearfix']/span[@class='pl']/text()").toString();
			rp = rp.trim();
			rp = rp.substring(1, rp.indexOf("人"));
			map.put("rating_people", rp);
			map.put("synopsis", new Html(context).xpath("//div[@class='info']/p/text()").toString());
			map.put("book", new Html(context)
					.xpath("//div[@class='info']/div[@class='ft']/div[@class='cart-actions']//a/@href").toString());
			//map.put("e_book", new Html(context)
				//	.xpath("//div[@class='info']/div[@class='ft']/div[@class='ebook-link']//a/@href").toString());
			list.add(map);
		}
		page.putField("list", list);
	}

	@Override
	public Site getSite() {
		return site;
	}

	public static void main(String[] args) {
		Spider.create(new DoubanBookProcessor())
				.addUrl("https://book.douban.com/tag/%E5%B0%8F%E8%AF%B4?start=20&type=T")
				.addPipeline(new ConsolePipeline()).thread(5).run();
	}
}
