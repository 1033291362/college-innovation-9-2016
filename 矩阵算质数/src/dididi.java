
public class dididi {
	public static void main(String[] args){
		int x=1;
		int y=0;
		for(int i=1;i<10000;i++){
			while(prime(i)==true){
				y++;
				System.out.println(y);
			}
		}
		System.out.println(y);
	}
	static boolean prime(int x){//ÅÐ¶ÏÊÇ·ñÎªËØÊý
		for(int i=2;i<x-1;i++){
			int t=x%i;
			if(t==0){
				return false;
			}
		}
		return true;
	}
}
