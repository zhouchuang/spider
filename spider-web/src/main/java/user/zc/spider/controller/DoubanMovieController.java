package user.zc.spider.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import user.zc.spider.Spider;
import user.zc.spider.entity.DoubanMovie;
import user.zc.spider.model.Result;
import user.zc.spider.pipeline.DoubanBookPipeline;
import user.zc.spider.pipeline.DoubanMoviePipeline;
import user.zc.spider.pipeline.UpdateDoubanMoviePipeline;
import user.zc.spider.process.DoubanBookProcessor;
import user.zc.spider.process.DoubanProcessor;
import user.zc.spider.process.UpdateDoubanProcessor;
import user.zc.spider.service.DoubanMovieService;

/**
 * 
 * @author zhouchuang
 * @version 1.0.0
 */
@Controller
@RequestMapping("/DoubanMovieController")
public class DoubanMovieController {

	@Autowired
	private DoubanMovieService doubanMovieService;
	
	private String[] topColors = {"#abbac3","#006dcc","#49afcd","#5bb75b","#faa732","#da4f49","#363636","#d6487e","#9585bf","#fee188","#abbac3","#e7e7e7"};

	@RequestMapping("/showRateTop/{year}")
	public String showMoviePage(ModelMap modelMap, @PathVariable Integer year) {
		if(StringUtils.isEmpty(year+""))year = new Date().getYear()+1900;
		HashMap map = new HashMap();
		map.put("release_date", year);
		if(year==-1){
			map.remove("release_date");
		}
		map.put("order", " order by  rate DESC limit 0,10");
		/*map.put("page_start", 0);
		map.put("page_end", 10);*/
		List<DoubanMovie> list = doubanMovieService.getList(map);
		for(int i=0;i<list.size();i++){
			list.get(i).setColor(topColors[i]);
		}
		modelMap.addAttribute("list", list);
		modelMap.addAttribute("year", year==-1?"所有":year);
		return "/douban/rate_top";
	}
	@RequestMapping("/showRatePeopleTop/{year}")
	public String showRatePeopleTop(ModelMap modelMap, @PathVariable Integer year) {
		if(StringUtils.isEmpty(year+""))year = new Date().getYear()+1900;
		HashMap map = new HashMap();
		map.put("release_date", year);
		if(year==-1){
			map.remove("release_date");
		}
		map.put("order", " order by  rating_people DESC limit 0,10");
		List<DoubanMovie> list = doubanMovieService.getList(map);
		for(int i=0;i<list.size();i++){
			list.get(i).setColor(topColors[i]);
		}
		modelMap.addAttribute("list", list);
		modelMap.addAttribute("year", year==-1?"所有":year);
		return "/douban/rating_people_top";
	}
	
	@RequestMapping("/showDirectTop")
	public String showDirectTop(ModelMap modelMap) {
		List<DoubanMovie> list = doubanMovieService.selectTopDirectList();
		for(int i=0;i<list.size();i++){
			list.get(i).setColor(topColors[i]);
		}
		modelMap.addAttribute("list", list);
		return "/douban/direct_top";
	}
	
	@RequestMapping("/showDirectFilms")
	public String showDirectFilms(ModelMap modelMap, @RequestParam String direct) {
		List<DoubanMovie> directs = doubanMovieService.selectTopDirectList();
		if(StringUtils.isEmpty(direct))direct = directs.get(0).getDirect();
		else{
			try {
				direct = new String (direct.getBytes("ISO8859-1"),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} 
		}
		HashMap map = new HashMap();
		map.put("direct", direct);
		map.put("order", " order by  rate DESC limit 0,10");
		List<DoubanMovie> list = doubanMovieService.getList(map);
		for(int i=0;i<list.size();i++){
			list.get(i).setColor(topColors[i]);
		}
		modelMap.addAttribute("list", list);
		modelMap.addAttribute("direct", direct);
		modelMap.addAttribute("directlist",directs);
		return "/douban/direct_film";
	}
	
	@RequestMapping("/startDoubanMovieSpider")
	public @ResponseBody Result startDoubanMovieSpider(ModelMap modelMap, @RequestParam String url) {
		Result result = new Result();
		DoubanProcessor process ;
		Spider.create(process  = new DoubanProcessor())
				.addUrl(url)
				//.addUrl("https://movie.douban.com/j/search_subjects?type=movie&tag=%E7%83%AD%E9%97%A8&sort=recommend&page_limit="+limit)
				.addPipeline(new DoubanMoviePipeline()).thread(5).run();
		result.setMsg("爬取完成,总共爬取了"+process.getCount()+"条数据");
		return result;
	}
	
	@RequestMapping("/startUpdateDoubanMovieSpider")
	public @ResponseBody Result startUpdateDoubanMovieSpider(ModelMap modelMap, @RequestParam String url,HttpServletRequest request) {
		Result result = new Result();
		UpdateDoubanProcessor process ;
		Spider.create(process  = new UpdateDoubanProcessor(request))
				.addUrl(url)
				.addPipeline(new UpdateDoubanMoviePipeline()).thread(5).run();
		result.setMsg("爬取完成,总共爬取了"+process.getCount()+"条数据");
		return result;
	}
	
	@RequestMapping("/startDoubanBookSpider")
	public @ResponseBody Result startDoubanBookSpider(ModelMap modelMap, @RequestParam String url) {
		Result result = new Result();
		DoubanBookProcessor process ;
		Spider.create(process  = new DoubanBookProcessor())
				.addUrl(url)
				//.addUrl("https://movie.douban.com/j/search_subjects?type=movie&tag=%E7%83%AD%E9%97%A8&sort=recommend&page_limit="+limit)
				.addPipeline(new DoubanBookPipeline()).thread(5).run();
		result.setMsg("爬取完成,总共爬取了"+process.getCount()+"条数据");
		return result;
	}
}
