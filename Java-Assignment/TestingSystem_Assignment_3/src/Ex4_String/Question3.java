package Ex4_String;

import java.util.Scanner;

public class Question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Viết chương trình để người dùng nhập vào tên và kiểm tra,
//		nếu tên chư viết hoa chữ cái đầu thì viết hoa lên

		checkName();

	}

	private static void checkName() {
		// TODO Auto-generated method stub
		String nhapTen;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Vui long nhap ho va ten:");
		nhapTen = scanner.nextLine();

		// khai bao mang , su dung .toCharArray de doi ve kieu Char
		char[] charArray = nhapTen.toCharArray();
		boolean foundSpace = true;

		// su dung for de duyet cac phan tu trong mang
		for (int i = 0; i < charArray.length; i++) {
			// neu ptu trong mang la 1 chu cai
			if (Character.isLetter(charArray[i])) {
				// kiem tra khoang trang co truoc chu cai
				if (foundSpace) {
					// doi chu cai thanh chu in hoa bang phuong thuc toUpperCase
					charArray[i] = Character.toUpperCase(charArray[i]);
					foundSpace = false;
				}
			} else {
				foundSpace = true;
			}
		}

		nhapTen = String.valueOf(charArray);
		System.out.println("chuoi sau khi doi:" + nhapTen);
	}

}
