import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1759 {
	static int L, C;
	static StringBuilder sb;
	static String[] all,answer;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		String str = "";
		StringTokenizer st = null;

		str = in.readLine();
		st = new StringTokenizer(str, " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		answer = new String[L];
		all = new String[C];
		
		str = in.readLine();
		st = new StringTokenizer(str, " ");
		for (int i = 0; i < C; i++) {
			String alphabet = st.nextToken();
			all[i]=alphabet;
		}
		Arrays.sort(all);
		combi(0, 0);
		System.out.println(sb);
	}

	private static void combi(int start, int cnt) {

		if (cnt == L) {
			int moCnt = 0;
			for (int i = 0; i < answer.length; i++) {
				if (answer[i].equals("a")|| answer[i].equals("e")|| answer[i].equals("i") || answer[i].equals("o") || answer[i].equals("u") ) {
					moCnt++;
				}
			}
			if (moCnt >= 1 && L-moCnt >= 2)
				sb.append(String.join("", answer)).append("\n");
			return;
		}
		for (int i = start; i < C; i++) {
			answer[cnt] = all[i];
			combi(i + 1, cnt + 1);
		}

	}

}
