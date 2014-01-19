package set;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {

	public static void main(String[] args) {
		Point[] p = {new Point(), new Point(2, 2), new Point(-1,2)};
		System.out.println(maxPoints(p));
	}
	public static int maxPoints(Point[] points){
		
		for(int i=0;i<points.length-1;i++){
			Map<Double, Integer> map = new HashMap<Double, Integer>();
			ArrayList<Double> list = new ArrayList<Double>();
			
			for(int j=i+1;j<points.length;j++){
				int dy = points[j].y-points[i].y;
				int dx = points[j].x-points[i].x;
				if(dx == 0) ;
				
//				if(map.containsKey(arg0))
			}
		}
		return 0;
	}
}

class Point{
	int x;
	int y;
	Point(){
		x = 0;
		y = 0;
	}
	Point(int a, int b){
		x = a;
		y = b;
	}
}