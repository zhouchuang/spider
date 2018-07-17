package user.zc.spider.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import user.zc.spider.Spider;
import user.zc.spider.model.Result;
import user.zc.spider.model.UserInfo;
import user.zc.spider.pipeline.ImagePipeline;
import user.zc.spider.processor.ImageProcessor;
import user.zc.spider.service.UserService;

/**  
 * 
 * @author zhouchuang  
 * @version 1.0.0 
 */
@Controller
@RequestMapping("/WelcomeController")
public class WelcomeController {

	
	@RequestMapping("/spider")
	public String showUserInfo(ModelMap modelMap){
		return "/home/welcome";
	}
	
	
	@RequestMapping("/douban")
	public String douban(ModelMap modelMap){
		return "redirect:/DoubanMovieController/showRateTop/-1";
	}
	
	
	@RequestMapping("/startSpider")
	@ResponseBody
	public Result startSpider(ModelMap modelMap){
		Result json  = new Result();
		Spider.create(new ImageProcessor()).
        addUrl("http://search.suning.com/iPhone%207/").
        addPipeline(new ImagePipeline("E:\\webmagic\\")).
        thread(5).
        run();
		json.setMsg("启动成功");
		return json;
	}
}
