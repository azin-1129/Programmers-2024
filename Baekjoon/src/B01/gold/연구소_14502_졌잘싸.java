package B01.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 연구소_14502_졌잘싸 {
	public static class Node{
		int x;
		int y;
		
		Node(int x, int y){
			this.x=x;
			this.y=y;
		}	
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return ("{"+x+", "+y+"}");
		}
	}
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1}; // 벽 전용
	
	static int[] wx= {-1,1,0,0,-1,-1,1,1};
	static int[] wy= {0,0,-1,1,-1,1,-1,1};
	static int N,M,result;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String[] numbers=br.readLine().split(" ");
		
		N=Integer.parseInt(numbers[0]);
		M=Integer.parseInt(numbers[1]);
		
		int[][] map=new int[N][M];
		boolean[][] visited=new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			map[i]=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		} // 간결하긴 한데.. 일일이 x,y로 값 넣는거 하면 벽 파악 빠를지도
		// 몸은 기억하는 코드인데 더 자세한 원리 알면 좋겠다.
		
		List<Node> nodeList=new ArrayList<>();
		
		// 벽 주변 공백 탐색
		Queue<Node> virusQ=new LinkedList<>();
			
		for(int x=0;x<N;x++) {
			for(int y=0;y<M;y++) {
				if(map[x][y]==1) {
					for(int z=0;z<8;z++) {
						int nx=x+wx[z];
						int ny=y+wy[z];
						
						if(nx>0 & nx<N & ny>0 & ny<M) {
							if(map[nx][ny]==0 & visited[nx][ny]==false) {
								visited[nx][ny]=true;
								nodeList.add(new Node(nx,ny));
							}
						}
					}
				}
				
				if(map[x][y]==2) {
					virusQ.add(new Node(x,y));
				}
			}			
		}
		System.out.println("해당 코드가 뽑은 벽 놓을 곳 유망지 리스트입니다.");
		System.out.println(nodeList.toString());
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		
		boolean[] nodeVisited=new boolean[nodeList.size()];
		
		//2. 노드 조합 구하기
		combination(virusQ, map, nodeList, nodeVisited, 0, 3);
		
		System.out.println(result);
	}

	private static void combination(Queue<Node> virusQ, int[][] map, List<Node> nodeList, boolean[] nodeVisited, int start, int cnt) {
		if(cnt==0) { // 벽 조합 완성
			System.out.println("해당 재귀에서 채택한 벽 조합입니다.");
			for(int j=0;j<nodeVisited.length;j++) {
				if(nodeVisited[j]) {
					map[nodeList.get(j).x][nodeList.get(j).y]=1;
					System.out.print(nodeList.get(j));
				}
			}
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			// 벽 부여 완료
			System.out.println("벽 부여를 완료한 지도입니다.");
			printArray(map);
			
			System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
			boolean[][] visited=new boolean[N][M];
			
			// 3. 바이러스 퍼뜨리기
			while(!virusQ.isEmpty()) {
				Node virus=virusQ.poll();
				
				for(int z=0;z<4;z++) {
					int nx=virus.x+dx[z];
					int ny=virus.y+dy[z];
					
					if(nx>0 & nx<N & ny>0 & ny<M) {
						if(map[nx][ny]==0 & visited[nx][ny]==false) {
							visited[nx][ny]=true;
							virusQ.add(new Node(nx,ny));
						}
					}
				}	
			}
			
			// 4. 안전영역 계산
			int resultTemp=0;
			
			for(int x=0;x<N;x++) {
				for(int y=0;y<M;y++) {
					if(map[x][y]==0) {
						resultTemp+=1;
					}
				}
			}
			
			result=Integer.min(result, resultTemp);
		}

		for(int i=start;i<nodeList.size();i++) {
			nodeVisited[i]=true;
			combination(virusQ, map, nodeList, nodeVisited, i+1, cnt-1);
			nodeVisited[i]=false;
		}
	}
	public static void printArray(int[][] map) {
		for(int x=0;x<N;x++) {
			for(int y=0;y<M;y++) {
				System.out.print(map[x][y]+" ");
			}
			System.out.println();
		}
	}
}
