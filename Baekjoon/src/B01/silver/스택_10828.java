package B01.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 스택_10828 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[N];
		int idx=-1;
		
		for(int n=0;n<N;n++) {
			st=new StringTokenizer(br.readLine()," ");
			
			switch(st.nextToken()) {
			case "push":
				idx+=1;
				arr[idx]=Integer.parseInt(st.nextToken());
				break;
			case "pop":
				if(idx>=0) {
					sb.append(arr[idx]+"\n");
					arr[idx]=0;
					idx-=1;
				}else {
					sb.append(idx+"\n");
				}
				break;
			case "size":
				sb.append((idx+1)+"\n");
				break;
			case "empty":
				if(idx>=0) {
					sb.append(0+"\n");
				}else {
					sb.append(1+"\n");
				}
				break;
			case "top":
				if(idx>=0) {
					sb.append(arr[idx]+"\n");
				}else {
					sb.append(-1+"\n");
				}
			}
			System.out.println("arr 상태:"+Arrays.toString(arr)
			+", idx:"+idx);
		}
		
		System.out.println(sb);	
	}
}
