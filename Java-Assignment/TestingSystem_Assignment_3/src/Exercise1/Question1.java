package Exercise1;

public class Question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Khai báo 2 số lương có kiểu dữ liệu là float.
//		Khởi tạo Lương của Account 1 là 5240.5 $
//		Khởi tạo Lương của Account 2 là 10970.055$
//		Khai báo 1 số int để làm tròn Lương của Account 1 và in số int đó ra
//		Khai báo 1 số int để làm tròn Lương của Account 2 và in số int đó ra
		Account ac1 = new Account();
		ac1.id = 1;
		ac1.salary = 5240.5f;
		
		Account ac2 = new Account();
		ac2.id = 2;
		ac2.salary = 10970.055f;
		
		int salary1 = (int)ac1.salary;
		System.out.println(salary1);
		
		int salary2 = (int)ac2.salary;
		System.out.println(salary2);
	}

}
