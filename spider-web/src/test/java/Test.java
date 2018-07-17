import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	/*	int a = -199;
		System.out.println(~a+1);
		
		int b = 199;
		System.out.println(~a+1);
		
		String  str = "189分钟";
		 Pattern p=Pattern.compile("^[^\\d]*(\\d+)[^\\d]*$");   
		 Matcher mc  = p.matcher(str);
		 while(mc.find()){
			 System.out.println(mc.group(1));
		 }
		 */
		 System.out.println(new Date().getYear()+1900);
	}

}
