package codecheck;

public class App {
	public static void main(String[] args) {
		for (int i = 0, l = args.length; i < l; i++) {
			int daysInYear = Integer.parseInt(args[0]); // 1年を構成する日数
			int daysInMonth = Integer.parseInt(args[1]); // 1ヶ月を構成する日数
			int daysInWeek = Integer.parseInt(args[2]); // 1週間を構成する日数
			String date = args[3]; // 日付(YYYY-MM-DD形式)
			System.out.println(calendar(daysInYear, daysInMonth, daysInWeek, date));
		}
	}

	static String calendar(int daysInYear, int daysInMonth, int daysInWeek,
			String date) {
		int year = Integer.parseInt(date.substring(0, 4));
		int month = Integer.parseInt(date.substring(5, 7));
		int day = Integer.parseInt(date.substring(8, 10));

		// 日が一週間の日数を越えている
		if (day > daysInWeek)
			return "-1";
		
		// 日が一カ月の日数を越えている
		if (day > daysInMonth)
			return "-1";

		int monthsInYear = daysInYear / daysInMonth;
		// 月が monthsInYear+1 を越えている
		if (month > monthsInYear + 1)
			return "-1";

		// 一年の日数を月の日数で割った余り
		int remPerYear = daysInYear % daysInMonth;

		// year-1 までの日数を月の日数で割った余り
		int remainder = ((year - 1) * daysInYear) % daysInMonth;

		remainder += remPerYear;

		// 閏年
		if (remainder >= daysInMonth)
			monthsInYear++;

		if (month <= monthsInYear) {
			// 曜日の配列を生成
			String[] dayOfTheWeek = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

			int daysElapsed = 1;
			daysElapsed += (year - 1) * daysInYear;
			daysElapsed += (month - 1) * daysInMonth;
			daysElapsed += day-1;
			
			// 何番目の曜日か計算
			int num = daysElapsed % daysInWeek;

			if (num == 0)
				return dayOfTheWeek[daysInWeek];
			else
				return dayOfTheWeek[num];
		} else {
			return "-1";
		}
	}
}
