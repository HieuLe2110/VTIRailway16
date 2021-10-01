package Ex4_String;

import java.util.Scanner;

public class Question6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		tachHoTen();

	}

	private static void tachHoTen() {
		// TODO Auto-generated method stub
		String fullName;
		String lastName = " ";
		String firstName = " ";
		String middleName = " ";

		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập họ và tên :");
		fullName = scanner.nextLine();

		fullName = fullName.trim();
		String[] words = fullName.split(" ");
		lastName = words[0];
		firstName = words[words.length - 1];
		for (int i = 1; i <= words.length - 2; i++) {
			middleName += words[i] + " ";
		}
		System.out.println("Họ là: " + lastName);
		System.out.println("Tên đệm là: " + middleName);
		System.out.println("Tên là: " + firstName);

	}

}
