
public class 公约数 {
	public static void main(String[] args) {
		int a = 48;
		int b = 42;
		System.out.println("最大公约数为："+getMaxGongyueshu(a,b));
		System.out.println("最小公倍数为："+getMixGongbeishu(a,b));
	}
	private static int getMaxGongyueshu(int a,int b){
		if(a<b){
			return getMaxGongyueshu(b,a);
		}else if(a==b||b==0){
			return a;
		}else{
			return getMaxGongyueshu(b,a%b);
		}
	}
	private static int getMixGongbeishu(int a,int b){
		int c = getMaxGongyueshu(a,b);
		if(c==1){
			return a*b;
		}else{
			return c*getMixGongbeishu(a/c,b/c);
			
		}
	}
}
