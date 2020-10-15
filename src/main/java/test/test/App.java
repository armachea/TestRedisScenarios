package test.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.ScheduledExecutorService;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		DateTime dt = new DateTime();
		// DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd / hh:mm:ss");

		// String str = dt.print(dt);

		// DateFormat df = new SimpleDateFormat("yyyy-MM-dd / hh:mm:ss");
		// df.setTimeZone(TimeZone.getTimeZone("UTC"));
		// String dd = df.format(new Date());

		// DateFormat dc = new SimpleDateFormat("yyyy-MM-dd / hh:mm:ss");
		// dc.setTimeZone(TimeZone.getTimeZone("GMT"));
		// String cc = dc.format(new Date());

		String number = "+0024911228";

		String firstCase = number.substring(0, 1);

		if (!firstCase.equals("+")) {
			System.out.println("add + sign");
		} else {
			System.out.println("do nothing");

		}

		// System.out.println("First character:"+firstCase);

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSS'Z'"); // Quoted "Z" to indicate UTC, no timezone
																				// offset
		TimeZone tz = TimeZone.getTimeZone("UTC");
		df.setTimeZone(tz);
		String nowAsISO = df.format(new Date());

		// public String checkCaller() {

		// }

		// DateTime dt = formatter.parseDateTime();

		// System.out.println("TIME 1 : " + nowAsISO);
		// System.out.println("TIME 2 : " + dd);
		// System.out.println("TIME : " + cc);

		// for(int i=0; i<20; i++){
		// System.out.println("the counter: "+ i +" date is: " + nowAsISO);
		// }

	}

	private String transform(String number) {

		// What is first char of number ?
		if (number != null) {
			String firstChar = number.substring(0, 1);
			if (!firstChar.equals("+")) {
				StringBuilder str = new StringBuilder(number);
				// number = str.insert(0, "+");
			}
		}
		return number;
	}

	
	
}
