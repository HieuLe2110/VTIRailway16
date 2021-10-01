package JavaAss1;

import java.time.LocalDate;
import java.util.Iterator;

import JavaAss1.Position.PositionName;

public class TestingSystem_Ass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Khoi tao gia tri department

		Department dept1 = new Department();
		dept1.id = 1;
		dept1.name = "Sale";

		Department dept2 = new Department();
		dept2.id = 2;
		dept2.name = "Marketing";

		Department dept3 = new Department();
		dept3.id = 3;
		dept3.name = "CEO";

		Department dept4 = new Department();
		dept4.id = 4;
		dept4.name = "Ke toan";

		Department dept5 = new Department();
		dept5.id = 5;
		dept5.name = "Nhan su";

		// Khoi tao gia tri Position

		Position pos1 = new Position();
		pos1.id = 1;
		pos1.name = PositionName.DEV;

		Position pos2 = new Position();
		pos2.id = 2;
		pos2.name = PositionName.TEST;

		Position pos3 = new Position();
		pos3.id = 3;
		pos3.name = PositionName.SCRUM_MASTER;

		Position pos4 = new Position();
		pos4.id = 4;
		pos4.name = PositionName.PM;

		Position pos5 = new Position();
		pos5.id = 5;
		pos5.name = PositionName.TEST;

		// khoi tao group

		Group group1 = new Group();
		group1.id = 1;
		group1.name = "Java Fresher";

		Group group2 = new Group();
		group2.id = 2;
		group2.name = "C# Fresher";

		Group group3 = new Group();
		group3.id = 3;
		group3.name = "Datebase";

		Group group4 = new Group();
		group4.id = 4;
		group4.name = "Testing System";

		// Khoi tao gia Account

		Account acc1 = new Account();
		acc1.id = 1;
		acc1.email = "daonq1@gmail.com";
		acc1.userName = "daonq1";
		acc1.fullName = "Dao Nguyen 1";
		acc1.department = dept1;
		acc1.position = pos1;
		acc1.createDate = LocalDate.now();
		acc1.groups = new Group[] { group1, group2, group3 };
//		Group[] groupAcc1 = { group1, group2, group3, group3 };
//		acc1.groups = groupAcc1;

		Account acc2 = new Account();
		acc2.id = 2;
		acc2.email = "daonq2@gmail.com";
		acc2.userName = "daonq2";
		acc2.fullName = "Dao Nguyen 2";
		acc2.department = dept2;
		acc2.position = pos2;
		acc2.createDate = LocalDate.of(2021, 03, 17);
		acc2.groups = new Group[] { group2 };

		Account acc3 = new Account();
		acc3.id = 3;
		acc3.email = "daonq3@gmail.com";
		acc3.userName = "daonq3";
		acc3.fullName = "Dao Nguyen 3";
		acc3.department = dept3;
		acc3.position = pos3;
		acc3.createDate = LocalDate.now();
		acc3.groups = new Group[] { group1, group3, group2 };
		
		Account acc4 = new Account();
		acc4.id = 4;
		acc4.email = "huanhoahong@gmail.com";
		acc4.userName = "thayHuan";
		acc4.fullName = "Bui Xuan Huan";
		acc4.department = dept3;
		acc4.position = pos3;
		acc4.createDate = LocalDate.now();
		acc4.groups = new Group[] { group1, group3, group2 };

		// add Group Account
		group1.accounts = new Account[] { acc1, acc3 };
		group2.accounts = new Account[] { acc1, acc2 };
		group3.accounts = new Account[] { acc1, acc2, acc3 };
		group4.accounts = new Account[] { acc1 };

//		Question 1:
//		Kiểm tra account thứ 2
//		Nếu không có phòng ban (tức là department == null) thì sẽ in ra text
//		"Nhân viên này chưa có phòng ban"
//		Nếu không thì sẽ in ra text "Phòng ban của nhân viên này là ..."	
		System.out.println("Answer ques 1: ");
		if (acc2.department == null) {
			System.out.println("Nhân viên này chưa có phòng ban");
		} else {
			System.out.println("Phòng ban của nhân viên " + acc2.fullName + " là : " + acc2.department.name);
		}

//		Question 2:
//			Kiểm tra account thứ 2
//			Nếu không có group thì sẽ in ra text "Nhân viên này chưa có group"
//			Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra text "Group của nhân viên
//			này là Java Fresher, C# Fresher"
//			Nếu có mặt trong 3 Group thì sẽ in ra text "Nhân viên này là người
//			quan trọng, tham gia nhiều group"
//			Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là
//			người hóng chuyện, tham gia tất cả các group"
		System.out.println("\nAnswer ques 2: ");
		if (acc1.groups.length == 0) {
			System.out.println("Nhân viên này chưa có group");
		} else if (acc2.groups.length == 1) {
			System.out.println("Group của nhân viên này là " + acc2.groups[0].name);
		} else if (acc2.groups.length == 2) {
			System.out.println("Group của nhân viên này là " + acc2.groups[0].name + acc2.groups[2].name);
		} else if (acc2.groups.length == 3) {
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
		} else if (acc2.groups.length == 4) {
			System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
		}

//		Question 3:
//			Sử dụng toán tử ternary để làm Question 1
		System.out.println("\nAnswer ques 3: ");
		System.out.println(acc2.groups.length == 0 ? "Nhân viên này chưa có phòng ban"
				: "Phòng ban của nhân viên " + acc2.fullName + " là : " + acc2.department.name);

//		Question 4:
//			Sử dụng toán tử ternary để làm yêu cầu sau:
//			Kiểm tra Position của account thứ 1
//			Nếu Position = Dev thì in ra text "Đây là Developer"
//			Nếu không phải thì in ra text "Người này không phải là Developer"
		System.out.println("\nAnswer ques 4: ");
		System.out.println(
				acc1.position.name == PositionName.DEV ? "Đây là Developer" : "Người này không phải là Developer");

//		Question 5:
//			Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau:
//			Nếu số lượng account = 1 thì in ra "Nhóm có một thành viên"
//			Nếu số lượng account = 2 thì in ra "Nhóm có hai thành viên"
//			Nếu số lượng account = 3 thì in ra "Nhóm có ba thành viên"
//			Còn lại in ra "Nhóm có nhiều thành viên"
		System.out.println("\nAnswer ques 5: ");
		int countAccInGroup1 = group1.accounts.length;
		switch (countAccInGroup1) {
		case 1:
			System.out.println("Nhóm có một thành viên");
			break;
		case 2:
			System.out.println("Nhóm có hai thành viên");
			break;
		case 3:
			System.out.println("Nhóm có ba thành viên");
			break;
		}

//		Question 6:
//			Sử dụng switch case để làm lại Question 2
		System.out.println("\nAnswer ques 6: ");
		int acc2Groups = acc2.groups.length;
		switch (acc2Groups) {
		case 0:
			System.out.println("Nhân viên này chưa có group");
			break;
		case 1:
			String ac2GroupName = acc2.groups.toString();
			switch (ac2GroupName) {
			case "Java Fresher":
				System.out.println("Group của nhân viên này là Java Fresher");
				break;
			case "C# Fresher":
				System.out.println("Group của nhân viên này là C# Fresher");
				break;
			}
			break;
		case 2:
			System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
			break;
		case 3:
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
			break;
		case 4:
			System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
			break;
		}

//		Question 7:
//			Sử dụng switch case để làm lại Question 4
		System.out.println("\nAnswer ques 7: ");

		String positionName = acc1.position.name.toString();
		switch (positionName) {
		case "DEV":
			System.out.println("Đây là Developer");
			break;
		default:
			System.out.println("Người này không phải là Developer");
			break;
		}

//		Question 8:
//			In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của
//			họ
		System.out.println("\nAnswer ques 8: ");

		Account[] accArray = { acc1, acc2, acc3, acc4 };
		for (Account account : accArray) {
			System.out.println("AccountID: " + account.id + " Email: " + account.email + " Name: " + account.fullName);
		}

//		Question 9:
//			In ra thông tin các phòng ban bao gồm: id và name
		System.out.println("\nAnswer ques 9: ");

		Department[] deptArray = { dept1, dept2, dept3, dept4, dept5 };
		for (Department department : deptArray) {
			System.out.println("DepartmentID: " + department.id + "DepartmentName: " + department.name);
		}

//		Question 10:
//			In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của
//			họ theo định dạng như sau:
//			Thông tin account thứ 1 là:
//			Email: NguyenVanA@gmail.com
//			Full name: Nguyễn Văn A
//			Phòng ban: Sale
//			Thông tin account thứ 2 là:
//			Email: NguyenVanB@gmail.com
//			Full name: Nguyễn Văn B
//			Phòng ban: Marketting
		System.out.println("\nAnswer ques 10: ");
		for (int i = 0; i < accArray.length; i++) {
			System.out.println("Thông tin của account " + (i + 1) + " là:");
			System.out.println(
					"AccountID: " + accArray[i].id + " Email: " + accArray[i].email + " Name: " + accArray[i].fullName);
		}

//		Question 11:
//			In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau:
//			Thông tin department thứ 1 là:
//			Id: 1
//			Name: Sale
//			Thông tin department thứ 2 là:
//			Id: 2
//			Name: Marketing
		System.out.println("\nAnswer ques 11: ");
		for (int j = 0; j < deptArray.length; j++) {
			System.out.println("Thông tin của department " + (j + 1) + " là:");
			System.out.println("AccountID: " + deptArray[j].id + "Name: " + deptArray[j].name);
		}

//		Question 12:
//			Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10
		System.out.println("\nAnswer ques 12: ");

		for (int i = 0; i < accArray.length; i++) {
			if (i < 2) {
				System.out.println("Thông tin của account " + (i + 1) + " là:");
				System.out.println("AccountID: " + accArray[i].id + " Email: " + accArray[i].email + " Name: "
						+ accArray[i].fullName);
			}
		}
		
//		Question 13:
//			In ra thông tin tất cả các account ngoại trừ account thứ 2
		System.out.println("\nAnswer ques 13: ");
		for (int i = 0; i < accArray.length; i++) {
			if (i != 1) {
				System.out.println("Thông tin của account " + (i + 1) + " là:");
				System.out.println("AccountID: " + accArray[i].id + " Email: " + accArray[i].email + " Name: "
						+ accArray[i].fullName);
			}
			
		}
		
//		Question 14:
//			In ra thông tin tất cả các account có id < 4
		System.out.println("\nAnswer ques 14: ");
		for (int i = 0; i < accArray.length; i++) {
			if (accArray[i].id < 4) {
				System.out.println("Thông tin của account " + (i + 1) + " là:");
				System.out.println("AccountID: " + accArray[i].id + " Email: " + accArray[i].email + " Name: "
						+ accArray[i].fullName);
			}
		}
		
//		Question 15:
//			In ra các số chẵn nhỏ hơn hoặc bằng 20
		System.out.println("\nAnswer ques 15: ");
		for (int i = 0; i <= 20; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
