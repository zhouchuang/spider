package user.zc.spider.entity;

import java.lang.reflect.Field;

public class EntityToMapperUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printInsertValue(DoubanBook.class);
	}
	public static void printInsertKey(Class clazz){
		Field[] field = clazz.getDeclaredFields();
		StringBuffer sb  = new StringBuffer();
		for(Field f : field){
			sb.append(f.getName()+",");
		}
		System.out.println(sb.toString().substring(0, sb.toString().length()-1));
	}
	
	public static void printInsertValue(Class clazz){
		
		Field[] field = clazz.getDeclaredFields();
		StringBuffer sb  = new StringBuffer();
		for(Field f : field){
			sb.append("#{"+f.getName()+" ,jdbcType="+getJdbcType(f.getType().toString())+"},\n");
		}
		System.out.println(sb.toString());
	}
	private static String getJdbcType(String type){
		String jdbcType = "";
		if(type.endsWith("String")){
			jdbcType = "VARCHAR";
		}else if(type.endsWith("Float")){
			jdbcType = "FLOAT";
		}else if(type.endsWith("Integer")){
			jdbcType = "INTEGER";
		}
		return jdbcType;
	}

}
