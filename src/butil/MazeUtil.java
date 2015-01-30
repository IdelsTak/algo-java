package butil;

public class MazeUtil {
	public static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

	public static char[][] getMatrix(String s){
		String[] as = s.split(" ");
		int M = as.length;
		int N = as[0].length();
		char[][] a = new char[M][N];
		for(int i = 0; i<M; i++){
			for(int j = 0; j<N; j++){
				a[i][j] = as[i].charAt(j);
			}
		}
		return a;
	}

}
