package B01.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 제로_10773 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int result=0;
		
		int K=Integer.parseInt(br.readLine());
		
		int[] numbers=new int[K];
		
		int index=0;
		
		for(int i=0;i<K;i++) {
			numbers[index]=Integer.parseInt(br.readLine());
			
			if(numbers[index]==0) {
				result-=numbers[index-1];
				index-=1;
				continue;
			}
			
			result+=numbers[index];
			index+=1;		
		}

		System.out.println(result);
	}

}
