package string;

import java.util.HashSet;
import java.util.Set;

class Solution1 {
	public int solve1(String[] emails) {
		Set<String> set = new HashSet<String>();
		
		for(String email : emails) {
			String localName = makeLocalName(email);
			String domainName = makeDName(email);
			
			set.add(localName + "@" + domainName);
		}
		return set.size();
	}

	private String makeLocalName(String email) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < email.length(); i++) {
			if(email.charAt(i) == '.') {
				continue;
			}
			if(email.charAt(i) == '+' || email.charAt(i) == '@') {
				break;
			}
			sb.append(email.charAt(i));
		}
		return sb.toString();
	}
	
	private String makeDName(String email) {
		return email.substring(email.indexOf("@") + 1);
	}
}

public class No01_UniqueEmailAddress1 {
	public static void main(String[] args) {
		String[] emails = {
			"test.email+james@coding.com",
			"test.e.mail+toto.jane@coding.com",
			"testemail+tom@cod.ing.com"
		};
		
		Solution1 s1 = new Solution1();
		System.out.println(s1.solve1(emails));
	}
}
