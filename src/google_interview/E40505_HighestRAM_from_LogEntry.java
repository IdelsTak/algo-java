/*
Solutions to http://www.careercup.com/question?id=5643933132521472


 */
package google_interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author andy
 */
public class E40505_HighestRAM_from_LogEntry {
	private static final List<LogEntry> logEntries = new ArrayList<>();
	private static final Map<Long, Long> times = new TreeMap<>();

	public static class LogEntry {

		public final long startTime; // start time of a job in millisec granularity
		public final long endTime; // end time of a job in millisec granularity.
		public final long ram; // the amount of ram the job occupies.
		public final long jobId;

		public LogEntry(long sTime, long eTime, long ram, long jobId) {
			this.startTime = sTime;
			this.endTime = eTime;
			this.ram = ram;
			this.jobId = jobId;
		}
	}

	public static void addTime(long time, long ram) {
		if (times.containsKey(time)) {
			times.put(time, ram + times.get(time));
		} else {
			times.put(time, ram);
		}
	}

	public static long findHighRAM() {
		times.clear();
		for (LogEntry entry : logEntries) {
			addTime(entry.startTime, entry.ram);
			addTime(entry.endTime, entry.ram * -1);
		}

		long curMem = 0, maxMem = 0;
		for (Map.Entry<Long, Long> e : times.entrySet()) {
			curMem += e.getValue();
			maxMem = (curMem > maxMem) ? curMem : maxMem;
		}
		return maxMem;
	}

	public static void main(String[] argv) {
		logEntries.add(new LogEntry(50, 200, 1000, 3));
		logEntries.add(new LogEntry(0, 100, 500, 1));
		logEntries.add(new LogEntry(10, 70, 300, 2));
		logEntries.add(new LogEntry(110, 220, 400, 4));
		logEntries.add(new LogEntry(175, 280, 750, 5));

		long highRam = findHighRAM();

		System.out.printf("Highest RAM used is: %d", highRam);
	}
}
