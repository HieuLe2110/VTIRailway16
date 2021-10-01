package Ex4_String;

import java.util.Scanner;

public class Question5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Viết chương trình để người dùng nhập vào họ, sau đó yêu cầu người
//		dùng nhập vào tên và hệ thống sẽ in ra họ và tên đầy đủ
		inputFullName();

	}

	private static void inputFullName() {
		// TODO Auto-generated method stub
		String firstName, lastName;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập họ:");
		firstName = scanner.nextLine();
		System.out.println("Nhập Tên:");
		lastName = scanner.nextLine();

		System.out.println("Họ tên đầy đủ: " + firstName.concat(lastName));
	}

}
