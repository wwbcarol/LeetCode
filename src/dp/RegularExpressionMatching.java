package dp;

public class RegularExpressionMatching {

	public static void main(String[] args) {
		RegularExpressionMatching a = new RegularExpressionMatching();
//		System.out.println(a.isMatch("aa", "a")==false);
//		System.out.println(a.isMatch("aa", "aa")==true);
//		System.out.println(a.isMatch("aaa", "a")==false);
//		System.out.println(a.isMatch("aa", "*")==true);
//		System.out.println(a.isMatch("aa", "a*")==true);
//		System.out.println(a.isMatch("ab", "?*")==true);
//		System.out.println(a.isMatch("aab", "c*a*b")==false);
//		System.out.println(a.isMatch("baacbcaac", "***c")==true);
//		System.out.println(a.isMatch("baacbcaac", "***c")==true);
		
		int[][] obstacleGrid = new int[][]{{1,0}};
		System.out.println(a.uniquePathsWithObstacles(obstacleGrid));
	}
	
//	public boolean isMatch(String s, String p) {
//      int ns = s.length();
//      int np = p.length();
//      
//      
//    }
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] sum = new int[m][n];
        
        sum[0][0] = 1-obstacleGrid[0][0];
        for(int i=1;i<m;i++){
            if(obstacleGrid[i][0]!=1&&sum[i-1][0]!='0')sum[i][0] = 1;
            else sum[i][0] = 0;
        }
        
        for(int j=1;j<n;j++){
            if(obstacleGrid[0][j]!=1&&sum[0][j-1]!='0')sum[0][j] = 1;
            else sum[0][j] = 0;
        }
        for (int i = 0; i < m; i++) {
			for(int j=0;j<n;j++){
				System.out.println(sum[i][j] + " ");
			}
			System.out.println("");
		}
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    sum[i][j] = 0;
                }else{
                    sum[i][j] = sum[i-1][j]+sum[i][j-1];
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
			for(int j=0;j<n;j++){
				System.out.println(sum[i][j] + " ");
			}
			System.out.println("");
		}
        return sum[m-1][n-1];
    }
	
	public boolean isMatch(String s, String p) {
	
		int plenNoStar = 0;
	    for (char c : p.toCharArray())
	        if (c != '*') plenNoStar++;
	    if (plenNoStar > s.length()) return false;
    
        int ns = s.length();
        int np = p.length();
        boolean[][] dp = new boolean[2][np+1];
        
        dp[0][0] = true;
        
        for(int j=1;j<=np;j++){
        	if(p.charAt(j-1)=='*')
        		dp[0][j] = dp[0][j-1];
        }

        for(int i=1;i<=ns;i++){
        	for(int j=1;j<=np;j++){
        		if(p.charAt(j-1)==s.charAt(i-1)||p.charAt(j-1)=='?'){
        			dp[1][j] = dp[0][j-1];
        		}else if(p.charAt(j-1) == '*'){
					dp[1][j] = dp[1][j-1]||dp[0][j-1]||dp[0][j];
        		}else{
    				dp[1][j] = false;
    			}
        	}
        	
        	for (int j = 0; j <= np; j++) {
				dp[0][j] = dp[1][j];
			}
        }
        
        return dp[0][np];

    }
}
