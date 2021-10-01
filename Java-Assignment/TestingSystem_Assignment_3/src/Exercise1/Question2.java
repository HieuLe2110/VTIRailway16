package Exercise1;

import java.util.Random;

public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Lấy ngẫu nhiên 1 số có 5 chữ số 
//		(những số dưới 5 chữ số thì sẽ thêm có số 0 ở đầu cho đủ 5 chữ số)
		int min = 0;
		int max = 99999;
		int a = (int) (Math.random() * max) + min;
		while (a < 10000) {
		a = a * 10;
		}
		System.out.println("Số ngẫu nhiên: " + a);
	}

}
