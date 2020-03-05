
import java.util.ArrayList;
import java.util.List;

public class PatternMatch {
	List<String> stringPermutations;

	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Invalid number of arguments");
			return;
		}
		int testCaseCount = Integer.parseInt(args[0]);
		String[] mainString = new String[testCaseCount];
		String[] testString = new String[testCaseCount];
		int argumentIndex = 0;
		for (int i = 0; i < testCaseCount; i++) {
			argumentIndex++;
			testString[i] = args[argumentIndex];
			argumentIndex++;
			mainString[i] = args[argumentIndex];
			boolean matchFound = false;
			int n = testString[i].length();
			PatternMatch pm = new PatternMatch();
			pm.stringPermutations = new ArrayList<String>();
			pm.getPermutation(testString[i], 0, n - 1);
			for (String string : pm.stringPermutations) {
				if (mainString[i].contains(string)) {
					System.out.println("YES");
					matchFound = true;
					break;
				}
			}

			if (!matchFound) {
				System.out.println("NO");
			}
		}

	}

	public List<String> getPermutation(String str, int l, int r) {
		List<String> stringPermutations = new ArrayList<String>();
		this.permute(str, l, r);
		return stringPermutations;
	}

	private void permute(String str, int l, int r) {
		if (l == r)
			stringPermutations.add(str);

		else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				permute(str, l + 1, r);
				str = swap(str, l, i);
			}
		}
	}

	public String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
}
