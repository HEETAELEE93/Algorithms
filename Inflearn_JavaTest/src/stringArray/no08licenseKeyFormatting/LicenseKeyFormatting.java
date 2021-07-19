package stringArray.no08licenseKeyFormatting;

class LicenseKeyFormat {
	public String licenseKeyFormatting (String str, int k) {
		String newStr = "";
		
		newStr = str.replace("-", "");
		newStr = newStr.toUpperCase();

		StringBuilder sb = new StringBuilder();
		for(char i : newStr.toCharArray()) {
			sb.append(i);
		}

		int length = newStr.length();
		for(int i = k; i < length; i= i+k) {
			sb.insert(length - i, '-');
		}
		//System.out.println(sb);
		
		return sb.toString();
	}
}

public class LicenseKeyFormatting {
	public static void main(String[] args) {
		String str = "8F3Z-2e-9-w";
		String str1 = "8-5g-3-J";
		int k = 4;
		LicenseKeyFormat lf = new LicenseKeyFormat();
		System.out.println(lf.licenseKeyFormatting(str, k));
		System.out.println(lf.licenseKeyFormatting(str1, k));
	}
}
