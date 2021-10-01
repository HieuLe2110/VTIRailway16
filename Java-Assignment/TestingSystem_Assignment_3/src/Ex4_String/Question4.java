package Ex4_String;

import java.util.Scanner;

public class Question4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Viết chương trình để người dùng nhập vào tên in từng ký tự trong tên
//		của người dùng ra
//		VD:
//		Người dùng nhập vào "Nam", hệ thống sẽ in ra
//		"Ký tự thứ 1 là: N"
//		"Ký tự thứ 1 là: A"
//		"Ký tự thứ 1 là: M"
		
		checkArray();
	}

	private static void checkArray() {
		// TODO Auto-generated method stub
		String nhapTen;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Vui long nhap ho va ten:");
		nhapTen = scanner.nextLine();
		
		char[] charArray = nhapTen.toCharArray();
//		boolean foundSpace = true;
		
//		for (int i = 0; i < charArray.length; i++) {
//			// neu ptu trong mang la 1 chu cai
//			if (Character.isLetter(charArray[i])) {
//				// kiem tra khoang trang co truoc chu cai
//				if (foundSpace) {
//					// doi chu cai thanh chu in hoa bang phuong thuc toUpperCase
//					charArray[i] = Character.toUpperCase(charArray[i]);
//					foundSpace = false;
//				}
//			} else {
//				foundSpace = true;
//			}
//		}
		
		nhapTen = String.valueOf(charArray);
		for (int j = 0; j < nhapTen.length(); j++) {
			System.out.println("Ký tự thứ " + j + " là: " + nhapTen.charAt(j));
		}
	}

}
