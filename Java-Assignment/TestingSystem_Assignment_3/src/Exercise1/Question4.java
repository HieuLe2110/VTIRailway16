package Exercise1;

import java.util.Scanner;

public class Question4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Viết 1 method nhập vào 2 số nguyên a và b và trả về thương của chúng

		int a, b;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap a: ");
		a = scanner.nextInt();
		do {
			System.out.println("Nhap b: ");
			b = scanner.nextInt();
			if (b == 0) {
				System.out.println("Vui long nhap so # 0");
			}
		} while (b == 0);

		scanner.close();

		System.out.println("Thuong 2 so " + a + " va " + b + " : " + (float) a / (float) b);

	}

}
