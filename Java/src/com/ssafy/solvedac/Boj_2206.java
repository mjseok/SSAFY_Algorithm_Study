import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2206 {
	static int min = -1;
	static int N,M;
	static int[][] map;
	static int[] dx =new int[] {0,0,1,-1};
	static int[] dy =new int[] {1,-1,0,0};
	static boolean[][] noisVisit;
	static boolean[][][] isVisit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		StringTokenizer st = null;
		str=in.readLine();
		st = new StringTokenizer(str," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		noisVisit=new boolean[N][M];
		isVisit = new boolean[N][M][2];//[2]벽을 부순 적이 있는가확인
		for(int i=0;i<N;i++) {
			str = in.readLine();
			for(int j =0 ; j<M;j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}//입력
		
		bfs(0,0);
		System.out.println(min);
	}
	private static void bfs(int sx,int sy) {
		Queue<int []> queue = new LinkedList<>();
		queue.add(new int[] {sx,sy,0,1});//시작부터 세니까
		int answer = 0;
	
		//벽 부순적이 있는지 확인하고 이전에 해당 벽을 부순적이 있는지 없는지 확인
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x =cur[0];
			int y =cur[1];
			int crash  = cur[2]; //0은 false, 1은 true
			int time = cur[3];
			if(x==N-1 && y==M-1) {
				answer= time;
				break;
			}
		    for (int d = 0; d <4; d++) {
				int nx = x+dx[d];
				int ny = y+dy[d];
				if(!check(nx,ny)) continue;
				if(map[nx][ny]==0  && !isVisit[nx][ny][crash]) {
					queue.add(new int[] {nx,ny,crash,time+1});
					isVisit[nx][ny][crash]=true;
				}
				if(map[nx][ny]==1 && crash==0 && !isVisit[nx][ny][1]) { //벽을 만났고 그 곳을 지나간 적이 없고 벽을 부순적이 없으면
					isVisit[nx][ny][crash]=true; // 지나갔다
					queue.add(new int[] {nx,ny,1,time+1}); //crash = 1 (부쉈다)
				}
					
			}
		}
		if(answer != 0 ) min = answer;
	}
	private static boolean check(int x, int y) {
		return x>=0 && x<N && y>=0 && y<M;
	}
}
