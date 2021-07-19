package string;

class LicenseKeyFormatting {
	public String solve(String s, int k) {
		
		String newStr = s.replace("-", "");
		newStr = newStr.toUpperCase();
		
		StringBuilder sb = new StringBuilder(newStr);
		
		int len = sb.length();
		
		for(int i = k; i < len; i+=k) {
			sb.insert(len-i, "-");
		}
		
		return sb.toString();
	}
}

public class No04_LicenseKeyFormatting {
	public static void main(String[] args) {
		LicenseKeyFormatting sol = new LicenseKeyFormatting();
		String s = "8F3Z-2e-9-wabcdef";
		int k = 4;
		System.out.println(sol.solve(s, k));
	}
}
