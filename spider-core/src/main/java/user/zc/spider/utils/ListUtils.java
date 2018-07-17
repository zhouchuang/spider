package user.zc.spider.utils;

import java.util.List;

public class ListUtils {
	public static String join(List<String> list ,String split){
		if(isNotEmpty(list)){
			StringBuffer sb  = new StringBuffer();
			for(String str : list){
				sb.append((sb.length()>0?split:"")+str);
			}
			return sb.toString();
		}
		return "";
	}
	public static boolean isNotEmpty(List<?> list){
		if(list!=null&&list.size()>0)return true;
		else
			return false;
	}
}
