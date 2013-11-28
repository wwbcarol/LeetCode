package string;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		MinimumWindowSubstring a = new MinimumWindowSubstring();
//		String s = a.minWindow("ADOBECODEBANC", "ABC");
		String s = a.minWindow("ABC", "ABC");
		System.out.println(s);
	}

	public String minWindow(String S, String T) {
		if (S.length() == 0)
			return "";
		if (T.length() > S.length())
			return "";
		int s[] = new int[256];
		int t[] = new int[256];

		for (int i = 0; i < T.length(); i++) {
			t[T.charAt(i)]++;
		}

		int num = 0;
		int ee = 0;
		int ss = 0;
		int minLength = S.length();
		boolean isFind = false;;
		for (int start = 0, end = 0; end < S.length(); end++) {
			
			if (s[S.charAt(end)] < t[S.charAt(end)])
				num++;
			s[S.charAt(end)]++;
//			System.out.println("num:" + num);
			if (num == T.length()) {
				System.out.println("window:"+S.substring(start, end+1));
				isFind = true;
				while(true){
					if(s[S.charAt(start)] > t[S.charAt(start)]){
						s[S.charAt(start)]--;
						start++;
					}else{
						System.out.println("smallwindow:"+S.substring(start, end+1));
						if(end-start+1<=minLength){
							ss = start;
							ee = end;
							minLength = end-start+1;
						}
						s[S.charAt(start)]--;
						start++;
						num--;
						break;
					}
				}
			}
		}
		return isFind?S.substring(ss, ee+1):"";
	}

}
