package codecheck;

public class App {
	public static void main(String[] args) {
		for (int i = 0, l = args.length; i < l; i++) {
			// 入力を空白で分割
			String[] strs = args[i].split(" ");
			int daysInYear = Integer.parseInt(strs[0]);
			int daysInMonth = Integer.parseInt(strs[1]);
			int daysInWeek = Integer.parseInt(strs[2]);
			String date = strs[3];
			System.out.println(calend(daysInYear, daysInMonth, daysInWeek, date));
		}
	}

	static String calend(int daysInYear, int daysInMonth, int daysInWeek,
			String date) {
		int year = Integer.parseInt(date.substring(0, 4));
		int month = Integer.parseInt(date.substring(5, 7));
		int day = Integer.parseInt(date.substring(8, 10));

		// 日が一カ月の日数を越えている
		if (day >= daysInMonth) {
			return "-1";
		}

		int monthsInYear = daysInYear / daysInMonth;
		// 月が monthsInYear +1 を越えている
		if (month > monthsInYear + 1)
			return "-1";

		String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String[] youbis = s.split("");

		// 一年の日数を月の日数で割った余り
		int remainder = daysInYear % daysInMonth;

		// year-1 までの日数を月の日数で割った余り
		int rema = ((year - 1) * daysInYear) % daysInMonth;

		rema += remainder;

		// うるう年
		if (rema >= daysInMonth)
			monthsInYear++;

		if (month <= monthsInYear) {
			int count = 0;
			count += (year - 1) * daysInYear;
			count += (month - 1) * daysInMonth;
			count += day;
			int youbi = count % daysInWeek;
			if (youbi == 0)
				return youbis[daysInWeek];
			else
				return youbis[youbi];
		} else {
			return "-1";
		}
	}
}
