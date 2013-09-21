package string;


public class ZigZagConversion {

	public static void main(String[] args) {
		String s = "0123456789";
		System.out.println(convert(s, 4));
	}
	public static String convert(String s, int nRows) {
		if (nRows==1) {
			return s;
		}
		
		int perZig = 2*nRows - 2;
		int nZig = (int)Math.ceil(s.length()/(double)perZig);
		
		StringBuffer result = new StringBuffer();
		
		for(int i=0;i<nRows;i++){
			if(i == 0){
				for(int j=0;j<nZig;j++){
					result.append(s.charAt(j*perZig));
				}
			}else if(i == nRows-1){
				for(int j=0;j<nZig-1;j++){
					result.append(s.charAt(j*perZig+i));
				}
				if((nZig-1)*perZig+i<s.length())
					result.append(s.charAt((nZig-1)*perZig+i));
			}else{
				for(int j=0;j<nZig-1;j++){
					result.append(s.charAt(j*perZig+i));
					result.append(s.charAt((j+1)*perZig-i));
				}
				if ((nZig-1)*perZig+i<s.length()) {
					result.append(s.charAt((nZig-1)*perZig+i));
				}
				if ((nZig)*perZig-i<s.length()) {
					result.append(s.charAt((nZig)*perZig-i));
				}
			}
			
			
		}
		return result.toString();
		
    }
}
