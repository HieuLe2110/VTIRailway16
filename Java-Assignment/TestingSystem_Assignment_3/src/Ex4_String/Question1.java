package Ex4_String;

import java.util.Scanner;

public class Question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó
//		(các từ có thể cách nhau bằng nhiều khoảng trắng );
		String a;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Vui long nhap xau du lieu:");
		a = scanner.nextLine();
		
		System.out.println("Số lượng các từ trong xâu kí tự: " + a.length());
	}

}
