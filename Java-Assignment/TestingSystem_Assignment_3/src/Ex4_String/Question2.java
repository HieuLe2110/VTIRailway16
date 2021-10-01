package Ex4_String;

import java.util.Scanner;

public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Nhập hai xâu kí tự s1, s2 nối xâu kí tự s2 vào sau xâu s1;

		String s1, s2;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập xâu kí tự s1: ");
		s1 = scanner.nextLine();
		System.out.println("Nhập xâu kí tự s2: ");
		s2 = scanner.nextLine();

		String s3 = s1 + s2;
		System.out.println("nối xâu kí tự s2 vào sau xâu s1: " + s3);

	}

}
