package B01.silver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 덩치_7568 {
	static class Person implements Comparable<Person>{
		int x,y, originIdx;

		public Person(int x, int y, int originIdx) {
			this.x = x;
			this.y = y;
			this.originIdx=originIdx;
		}

		@Override
		public int compareTo(Person o) {
			return Integer.compare(this.x, o.x) + Integer.compare(this.y,  o.y);
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "(x:"+x+", y:"+y+", originIdx:"+originIdx+")";
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		Person[] personArray=new Person[N];
		
		for(int n=0;n<N;n++) {
			String[] xy=br.readLine().split(" ");
			personArray[n]=new Person(
					Integer.parseInt(xy[0]),
					Integer.parseInt(xy[1]),
					n);
		}
//		System.out.println("정렬 이전 리스트입니다.");
//		for(int n=0;n<N;n++) {
//			System.out.print(personArray[n]+" ");
//		}
//		System.out.println();
//		
		Arrays.sort(personArray); // 오름차순
//		
//		System.out.println("정렬된 리스트입니다.");
//		for(int n=0;n<N;n++) {
//			System.out.print(personArray[n]+" ");
//		}
//		
//		System.out.println();
		
		int[] result=new int[N];
		
		for(int n=0;n<N;n++) {
			int bigCnt=1;
			for(int m=0;m<N;m++) {
				if(personArray[m].x>personArray[n].x
						& personArray[m].y>personArray[n].y) {
					bigCnt+=1;
				}
			}
			result[personArray[n].originIdx]=bigCnt;
		}

			System.out.println(Arrays.toString(result).replaceAll("[\\[\\],]", ""));

			br.close();
	}

}
