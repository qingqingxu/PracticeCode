package nowcode;

public class Visit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] map = {{0,1,0},{2,0,0}};
		System.out.println(countPath(map, 2, 3));
	}
	
	public static int countPath(int[][] map, int n, int m) {
        // write code here
		int xm = 0,ym = 0,xb = 0,yb = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j]==1) {
					xm = i;
					ym = j;
				}else if (map[i][j]==2) {
					xb = i;
					yb = j;
				}
			}
		}
		
		int dirx = xm>xb?-1:1;
		int diry = ym>yb?-1:1;
		int[][] plan = new int[n][m];
		for (int i = xm; i!=xb+dirx ; i+=dirx) {
			for (int j = ym; j!=yb+diry; j+=diry) {
				if(xm==i&&ym==j){
					plan[i][j] = 1;
				}else if (map[i][j]==-1) {
					plan[i][j]=0;
				}else if (i==xm) {
					plan[i][j] = plan[i][j-diry];
				}else if (j==ym) {
					plan[i][j] = plan[i-dirx][j];
				}else {
					plan[i][j] = plan[i][j-diry] + plan[i-dirx][j];
				}
			}
		}
		return plan[xb][yb];
    }

}
