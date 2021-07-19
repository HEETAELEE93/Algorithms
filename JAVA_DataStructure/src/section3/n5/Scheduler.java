package section3.n5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Scheduler {
//	private int capacity = 10;
	public ArrayList<Event> events = new ArrayList<Event>();
//	Event[] events = new Event[capacity];
//	int n = 0;

	private Scanner kb;

	public void processCommand() {
		kb = new Scanner(System.in);
		while (true) {
			System.out.print("$ ");
			String command = kb.next();

			if (command.equals("addevent")) {
				String type = kb.next();
				if (type.equalsIgnoreCase("oneday")) {
					handleAddOneDayEvent();
				} else if (type.equalsIgnoreCase("duration")) {
					handleAddDurationEvent();
				} else if (type.equalsIgnoreCase("deadline")) {
					handleAddDeadlinedEvent();
				}
			} else if (command.equals("list")) {
				handleList();
			} else if (command.equals("show")) {
				handleShow();
			} else if (command.equals("sort")) {
//				Arrays.sort(events, 0, n);
				Collections.sort(events);
			} else if (command.equals("exit")) {
				break;
			}
		}
		kb.close();
	}

	private void handleShow() {
		String dateString = kb.next();
		MyDate theDate = parseDateString(dateString);
//		for(int i = 0; i < events.size(); i++) {
//			if(events.get(i).isRelevant(theDate)) {
//				System.out.println(events.get(i).toString());
//			}
//		}
		for(Event ev : events) {
			if(ev.isRelevant(theDate)) {
				System.out.println(ev.toString());
			}
		}
	}

	private void handleList() {
//		for (int i = 0; i < events.size(); i++) {
//			System.out.println("  " + events.get(i).toString());
//		}
		for(Event ev : events) {
			System.out.println("  " + ev.toString());
		}
	}

	private void handleAddDeadlinedEvent() {
		System.out.println("until: ");
		String until = kb.next();

		System.out.print("title: ");
		String title = kb.next();

		MyDate date = parseDateString(until);

		DeadlinedEvent deadEv = new DeadlinedEvent(title, date);
		addEvent(deadEv);
	}

	private void handleAddDurationEvent() {
		System.out.print("begin: ");
		String begin = kb.next();

		System.out.print("end: ");
		String end = kb.next();

		System.out.print("title: ");
		String title = kb.next();

		MyDate date1 = parseDateString(begin);
		MyDate date2 = parseDateString(end);

		DurationEvent duEv = new DurationEvent(title, date1, date2);
		addEvent(duEv);
	}

	private void handleAddOneDayEvent() {
		System.out.print("when: ");
		String dateString = kb.next(); // dateString = "2020/03/18"

		System.out.print("title: ");
		String title = kb.next();

		MyDate date = parseDateString(dateString);

		OneDayEvent ev = new OneDayEvent(title, date);
		addEvent(ev);
	}

	private MyDate parseDateString(String dateString) { // dateString = "2020/03/18"
		String[] tokens = dateString.split("/");

		int year = Integer.parseInt(tokens[0]);
		int month = Integer.parseInt(tokens[1]);
		int day = Integer.parseInt(tokens[2]);

		MyDate d = new MyDate(year, month, day);

		return d;
	}

	private void addEvent(Event ev) {
//		if (n >= capacity) {
//			reallocate();
//		}
		events.add(ev);
	}


	// 배열 재할당
//	private void reallocate() {
//		Event[] tmp = new Event[capacity * 2];
//		for (int i = 0; i < n; i++) {
//			tmp[i] = events.get(i);
//		}
//		events = tmp;
//		capacity *= 2;
//	}

	public static void main(String[] args) {

		Scheduler app = new Scheduler();
		app.processCommand();
	}
}