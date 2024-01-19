package B01.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 분수찾기_1193 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int X=Integer.parseInt(br.readLine());
		
		int left=1;
		int right=1;
		
		int leftCalc=1;
		int rightCalc=1;
		
		for(int i=2;i<=X;i++) {
//			System.out.println("left:"+left+", right:"+right 
//					+", left Calc:"+leftCalc
//					+", right Calc:"+rightCalc);
			if(X==1) {
				break;
			}
			
			if(left==1 & rightCalc==1) {
				right+=1;
				leftCalc=1;
				rightCalc=-1;
				continue;
			}
			
			if(right==1 & leftCalc==1) {
				left+=1;
				leftCalc=-1;
				rightCalc=1;
				continue;
			}

			left+=leftCalc;
			right+=rightCalc;
		}
//		System.out.println("finished.");
//		
//		System.out.println("left:"+left+", right:"+right);
		
		sb.append(left+"/"+right);
		System.out.println(sb);
	}

}
