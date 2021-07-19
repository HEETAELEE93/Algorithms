package string;

import java.util.HashSet;
import java.util.Set;

class Solution2 { // use SPLIT
	public int solve1(String[] emails) {
		Set<String> set = new HashSet<String>();
		
		for(String email : emails) {
			String[] part = email.split("@");
			String[] localName = part[0].split("\\+");
			set.add(localName[0].replace(".", "") + "@" + part[1]);
		}
		
		return set.size();
	}
}

public class No02_UniqueEmailAddress2 {
	public static void main(String[] args) {
		String[] emails = {
			"test.email+james@coding.com",
			"test.e.mail+toto.jane@coding.com",
			"testemail+tom@cod.ing.com"
		};
		
		Solution2 s2 = new Solution2();
		System.out.println(s2.solve1(emails));
	}
}
