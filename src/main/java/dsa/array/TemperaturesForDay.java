package dsa.array;

import java.util.Scanner;

public class TemperaturesForDay {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		daysAboveAverage();
		scanner.close();

	}

	private static void daysAboveAverage() {

		final int numberOfDays = getNumberOfDaysFromUser();

		float[] arr = new float[numberOfDays];

		float sumOfAllTemperatures = 0;

		//record user input to array data structure  and calculate sum of all temperatures
		for (int i = 0; i < numberOfDays; i++) {
			int day = i + 1;
			final float temperature = getTemperatureForDayFromUser(day);
			arr[i] = temperature;
			sumOfAllTemperatures += temperature;
		}

		float averageTemperature = sumOfAllTemperatures / numberOfDays;
		final int daysAboveAverage = calculateNumberOfDaysAboveAverageTemperature(arr, averageTemperature);

		System.out.println("Average temperature =" + averageTemperature);
		System.out.println("Days above average temperature =" + daysAboveAverage);
	}

	private static int calculateNumberOfDaysAboveAverageTemperature(float[] arr, float averageTemperature) {
		int daysOboverAverage = 0;
		for (float v : arr) {
			if (v > averageTemperature) {
				daysOboverAverage++;
			}
		}
		return daysOboverAverage;
	}

	private static int getNumberOfDaysFromUser() {
		System.out.println("Enter number of days:");
		return scanner.nextInt();
	}

	private static float getTemperatureForDayFromUser(int day) {
		System.out.println("Enter temperature for day " + day + ":");
		return scanner.nextFloat();
	}
}
