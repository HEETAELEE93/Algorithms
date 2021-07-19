package stringArray.no11uniqueEmailAddress;

import java.util.HashSet;
import java.util.Set;

class Solution{
	public int numUniqueEmails(String[] emails) {
		double start = System.nanoTime();
		
		Set<String> hs = new HashSet<String>();
		
		for(String email : emails) {
			String localName = makeLocalName(email);
			String domainName = makeDomainName(email);
			hs.add(localName +  domainName);
		}
		
		double end = System.nanoTime();
		System.out.println("실행 시간 : " + ( end - start ) / 1000.0);
		return hs.size();
	}

	private String makeLocalName(String email) {
		StringBuilder sb = new StringBuilder();
		
//		for(int i = 0; i < email.length(); i++) {
//			// 1. 에러체크
//			if(email.charAt(i) == '.') {
//				continue;
//			} else if(email.charAt(i) == '+') {
//				break;
//			} else if(email.charAt(i) == '@') {
//				break;
//			}
//			
//			// 2. sb에 append
//			String str = String.valueOf(email.charAt(i));
//			//char str = email.charAt(i);
//			
//			sb.append(str);
//		}
		
		for(char e : email.toCharArray()) {
			if(e == '.') {
				continue;
			} else if(e == '+') {
				break;
			} else if(e == '@') {
				break;
			}
			char str = e;
			sb.append(str);
		}
		
		return sb.toString();
	}
	
	private String makeDomainName(String email) {
		return email.substring(email.indexOf('@'));
	}

}

class MySolution{
	public int numUniqueEmails(String[] emails) {
		double start = System.nanoTime();
		
		Set<String> hs = new HashSet<String>();
		
		for(String email : emails) {
			String[] str = email.split("@");
			
			str[0] = str[0].replace(".", "");
			if(str[0].contains("+")) {
				str[0] = str[0].substring(0, str[0].indexOf("+"));
			}
			
			String result = str[0] + "@" + str[1];
			hs.add(result);
		}
		
		double end = System.nanoTime();
		System.out.println("실행 시간 : " + ( end - start ) / 1000.0);
		return hs.size();
	}
}

public class UniqueEmailAdress {
	public static void main(String[] args) {
		String[] emails = {
			"test.email+james@coding.com",
			"test.e.mail+toto.jane@coding.com",
			"testemail+tom@cod.ing.com"
		};
	
		Solution s = new Solution();
		System.out.println(s.numUniqueEmails(emails));
		System.out.println("==================");
		MySolution ms = new MySolution();
		System.out.println(ms.numUniqueEmails(emails));
	}
}
