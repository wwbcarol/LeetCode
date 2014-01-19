package string;

public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters a = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(a.lengthOfLongestSubstring("abcabcbb"));
	}

	public int lengthOfLongestSubstring(String s) {
		int slist[] = new int[256];
		int max = 0;
		for (int start = 0, end = 0; end < s.length(); end++) {
			if (slist[s.charAt(end)] == 0) {
				slist[s.charAt(end)]++;
				if (end == s.length() - 1) {
					if (end - start + 1 > max) {
						max = end - start + 1;
					}
				}
			} else {
				slist[s.charAt(end)]++;
				if (end - start > max) {
					max = end - start;
				}
				while (true) {
					slist[s.charAt(start)]--;
					start++;
					if (s.charAt(start - 1) == s.charAt(end))
						break;
				}
			}
		}

		return max;
	}
}
