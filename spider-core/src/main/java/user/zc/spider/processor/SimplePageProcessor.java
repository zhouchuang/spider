package user.zc.spider.processor;


import java.util.List;

import user.zc.spider.Page;
import user.zc.spider.Site;
import user.zc.spider.utils.UrlUtils;

/**
 * A simple PageProcessor.
 *
 * @author code4crafter@gmail.com <br>
 * @since 0.1.0
 */
public class SimplePageProcessor implements PageProcessor {

    private String urlPattern;

    private Site site;

    public SimplePageProcessor(String startUrl, String urlPattern) {
        this.site = Site.me().addStartUrl(startUrl).
                setDomain(UrlUtils.getDomain(startUrl));
        //compile "*" expression to regex
        this.urlPattern = "(" + urlPattern.replace(".", "\\.").replace("*", "[^\"'#]*") + ")";

    }

    @Override
    public void process(Page page) {
        List<String> requests = page.getHtml().links().regex(urlPattern).all();
        //add urls to fetch
        page.addTargetRequests(requests);
        //extract by XPath
        page.putField("title", page.getHtml().xpath("//title"));
        page.putField("html", page.getHtml().toString());
        //extract by Readability
        page.putField("content", page.getHtml().smartContent());
    }

    @Override
    public Site getSite() {
        //settings
        return site;
    }
}
