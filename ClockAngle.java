public class ClockAngle {

	private static final int MINUTES_PER_HOUR = 60;
	private static final int DEGREES_PER_MINUTE = 6;
	private static final int DEGREE_PER_HOUR = 30;

	public static double getClockAngle(String time) {
		double angle = 0;
		String[] times = time.split(":");
		int hours = Integer.valueOf(times[0]) % 12;
		int minutes = Integer.valueOf(times[1]) % 60;

		double angleToMinutes = minutes * DEGREES_PER_MINUTE;
		double angleToHours = hours * DEGREE_PER_HOUR
					+ (minutes / MINUTES_PER_HOUR) * DEGREE_PER_HOUR;

		angle = Math.abs(angleToMinutes - angleToHours);

		return angle > 180 ? 360 - angle : angle;
	}

	public static void main(String[] args) {
		System.out.println(getClockAngle("24:00"));
	}
}
