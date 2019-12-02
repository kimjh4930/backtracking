package b_9663;

import java.util.Scanner;

public class Main {
	
	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	
	static int N, count;
	
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		
		char[][] map = new char[15][15];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = '0';
			}
		}
		
		dfs(0, map);
		
		System.out.println(count);
		
		scan.close();
	}
	
	static void dfs (int depth, char[][] tempMap) {
		
		if(depth == N) {
			count++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			//빈칸인 경우.
			if(tempMap[depth][i] == '0') {
				//queen을 입력하고, 범위를
				char[][] nextMap = copyMap(tempMap);
				nextMap[depth][i] = '2';	//queen을 놓는다.
				setQueenAttackRange(i, depth, nextMap);
//				printMap(nextMap);
				dfs(depth+1, nextMap);
			}
		}
	}
	
	static boolean checkMapRange (int x, int y) {
		if(x>=0 && x<N && y>=0 && y<N) {
			return true;
		}
		return false;
	}
	
	static void setQueenAttackRange(int x, int y, char[][] tempMap) {
		int tx, ty;
		
		for(int i=0; i<7; i++) {
			
			tx = x + dx[i];
			ty = y + dy[i];
			
			while(true) {
				if(!checkMapRange(tx, ty)) {
					break;
				}
				
				tempMap[ty][tx] = '1';
				tx += dx[i];
				ty += dy[i];
			}
		}
	}
	
	static char[][] copyMap (char[][] tempMap) {
		
		char[][] nextMap = new char[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				nextMap[i][j] = tempMap[i][j];
			}
		}
		
		return nextMap;
	}
	
	static void printMap (char[][] tempMap) {
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(tempMap[i][j] == '0') {
					System.out.print("0 ");
				}else if(tempMap[i][j] == '1') {
					System.out.print("X ");
				}else {
					System.out.print("Q ");
				}
			}
			System.out.println("");
		}
	}

}
