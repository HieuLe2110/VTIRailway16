package Ex3_BoxingAndUnBoxing;

public class Question1 {
	public static void main(String[] args) {
//	Khởi tạo lương có datatype là Integer có giá trị bằng 5000.
//	Sau đó convert lương ra float và hiển thị lương lên màn hình (với số
//	float có 2 số sau dấu thập phân)

		Integer a = 5000;
		float Salary = a.intValue();
		System.out.printf("%.2f", Salary);
	}
}
