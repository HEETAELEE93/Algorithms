package recursion;

public class Recursion03 {

	// 순차 탐색(매개변수 암시적)
	public static int search(int[] data, int target) {
		for (int i = 0; i < data.length; i++)
			if (data[i] == target)
				return i;
		return -1;
	}

	// 순차 탐색 - 매개변수의 명시화
	public static int search2(int[] data, int begin, int end, int target) {
		if (begin > end)
			return -1;
		else if (target == data[begin])
			return begin;
		else
			return search2(data, begin + 1, end, target);
	}

	// 순차검색 - 이진트리
	public static int search3(int[] data, int begin, int end, int target) {
		if (begin > end) {
			return -1;
		} else {
			int middle = (begin + end) / 2;

			if (data[middle] == target) {
				return middle;
			}

			int index = search3(data, begin, middle - 1, target);
			if (index != -1) {
				return index;
			} else {
				return search3(data, middle + 1, end, target);
			}
		}
	}

	// 최대값 찾기 - 매개변수의 명시화
	public static int findMax(int[] data, int begin, int end) {
		if (begin == end)
			return data[begin];
		else
			return Math.max(data[begin], findMax(data, begin + 1, end));
	}

	// 최대값 찾기 - 다른 버전
	public static int findMax2(int[] data, int begin, int end) {
		if (begin == end) {
			return data[begin];
		} else {
			int middle = (begin + end) / 2;
			int max1 = findMax2(data, begin, middle);
			int max2 = findMax2(data, middle + 1, end);
			return Math.max(max1, max2);
		}
	}

	// 최대값 찾기 - 이진탐색
	public static int binarySearch(String[] items, String target, int begin, int end) {
		if (begin == end) {
			return -1;
		} else {
			int middle = (begin + end) / 2;
			int compResult = target.compareTo(items[middle]);
			if (compResult == 0) {
				return middle;
			} else if (compResult < 0) {
				return binarySearch(items, target, begin, middle - 1);
			} else {
				return binarySearch(items, target, middle + 1, end);
			}
		}
	}

	public static void main(String[] args) {
		int[] data = { 1, 2, 3 };
		int target = 3;
		System.out.println(search(data, target));
		int begin = 0;
		int end = 1;
		System.out.println(search2(data, begin, end, target));
	}
}
