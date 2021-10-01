package Exercise1;

public class Question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Lấy 2 số cuối của số ở Question 2 và in ra.
//		Gợi ý:
//		Cách 1: convert số có 5 chữ số ra String, sau đó lấy 2 số cuối
//		Cách 2: chia lấy dư số đó cho 100
		int min = 0;
		int max = 99999;
		int a = (int) (Math.random() * max) + min;
		while (a < 10000) {
		a = a * 10;
		}
		System.out.println("Số ngẫu nhiên: " + a);
		
		String b = String.valueOf(a);
		System.out.println("Hai số cuối: "+ b.substring(3));
		
	}

}
