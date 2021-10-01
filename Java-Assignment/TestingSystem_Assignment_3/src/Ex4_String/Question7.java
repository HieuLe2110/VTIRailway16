package Ex4_String;

import java.util.Scanner;

public class Question7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và
//		chuẩn hóa họ và tên của họ như sau:
//		a) Xóa dấu cách ở đầu và cuối và giữa của chuỗi người dùng nhập
//		vào
//		b) Viết hoa chữ cái mỗi từ của người dùng

		chuanHoaTen();
	}

	private static void chuanHoaTen() {
		// TODO Auto-generated method stub
		String nhapTen;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Vui long nhap ho va ten:");
		nhapTen = scanner.nextLine();
		nhapTen = nhapTen.trim();	
		
		char[] charArray = nhapTen.toCharArray();
		boolean foundSpace = true;

		for (int i = 0; i < charArray.length; i++) {
			if (Character.isLetter(charArray[i])) {
				if (foundSpace) {
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
