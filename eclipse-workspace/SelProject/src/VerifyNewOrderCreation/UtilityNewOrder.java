package VerifyNewOrderCreation;

import java.util.Random;

public abstract class UtilityNewOrder {
	public static int twoDigitsNum = (int) (Math.random() * 100);
	public static int fiveDigitsNum = (int) (Math.random() * 10000) + 20000;

	public static String randomString() {
		
		int a = 0;
		String answer = "";

		int i = 1;
		Random rand = new Random();
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		while (i <= a) {
			int r = rand.nextInt(25);

			char ans = alphabet.charAt(r);
			if (i == 1) {
				answer = answer + ans;
			} else {
				answer = ans + answer.toLowerCase();
			}
			i++;
		}
		System.out.println(answer);
		return answer;

	}

	public static int randomQuantity(int r) {
		Random random = new Random();
		int ran = 1 + random.nextInt(r);

		return ran;
	}

	public static String randomString(int a) {
		String answer = "";

		int i = 1;
		Random random = new Random();
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		while (i <= a) {
			int r = random.nextInt(25);

			char ans = alphabet.charAt(r);
			if (i == 1) {
				answer = answer + ans;
			} else {
				answer = ans + answer.toLowerCase();
			}
			i++;
		}
		System.out.println(answer);
		return answer;

	}

	public static String randomNumber(int a) {
		String random = "";
		for (int i = 0; i < a; i++) {
			random = random + UtilityNewOrder.randomQuantity(9);
		}
		// System.out.println(random);
		return random;
	}

	public static String expirationDate() {
		String date = "";
		String month = "";
		int m = 1 + randomQuantity(12);

		if (m < 10) {
			month = "0" + Integer.toString(m);
		} else {
			month = Integer.toString(m);
		}

		int year = 20 + randomQuantity(5);
		date = month + "/" + year;
		return date;

	}

	public static String Visa() {
		String cardNumber = "4";
		cardNumber = cardNumber + randomNumber(15);

		return cardNumber;

	}

	public static String Master() {
		String cardNumber = "5";
		cardNumber = cardNumber + randomNumber(15);

		return cardNumber;

	}

	public static String AmericanExpress() {
		String cardNumber = "3";
		cardNumber = cardNumber + randomNumber(14);

		return cardNumber;

	}

}
