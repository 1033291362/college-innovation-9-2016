public class suan {
	public static void main(String[] args){
		int N = 5;
		int[][] matrix=new int[N][N];
		matrix[0][0]=1;
		int i=0,j=0,k=0,l=0;
		int num=2;
		for(i=1;i<N;i++){
			matrix[i][0]=num;
			k=matrix[i-1][0]+matrix[i][0];
			while(prime(k)!=true){
				num++;
				matrix[i][0]=num;
				k=matrix[i-1][0]+matrix[i][0];
			}
		}
		for(j=1;j<N;j ++){
			matrix[0][j]=num;
			k=matrix[0][j-1]+matrix[0][j];
			while(prime(k)!=true){
				num++;
				matrix[0][j]=num;
				k=matrix[0][j-1]+matrix[0][j];
			}
		}
		for(j=1;j<N;j++){
			for(i=1;i<N;i++){
				matrix[i][j]=num;
				k=matrix[i-1][j]+matrix[i][j];
				l=matrix[i][j-1]+matrix[i][j];
				while(prime(k)!=true&&(prime(l)!=true)){
					num++;
					matrix[i][j]=num;
					k=matrix[i-1][j]+matrix[i][j];
					l=matrix[i][j-1]+matrix[i][j];
				}
				
			}
		}
		
		
		
		
		
		
		
		
		
		
		String[] sb = new String[N];//输出
		for(j=0;j<N;j++){//输出
			for(i=0;i<N;i++){
				sb[j]=sb[j]+matrix[i][j]+",";
			}
		}
		for(j=0;j<N;j++){//也是输出
			System.out.println(sb[j]);
		}
	}
	static boolean prime(int x){//判断是否为素数
		for(int i=2;i<x-1;i++){
			int t=x%i;
			if(t==0){
				return false;
			}
		}
		return true;
	}

}
