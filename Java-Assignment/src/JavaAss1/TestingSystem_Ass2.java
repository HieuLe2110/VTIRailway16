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
//		Ki???m tra account th??? 2
//		N???u kh??ng c?? ph??ng ban (t???c l?? department == null) th?? s??? in ra text
//		"Nh??n vi??n n??y ch??a c?? ph??ng ban"
//		N???u kh??ng th?? s??? in ra text "Ph??ng ban c???a nh??n vi??n n??y l?? ..."	
		System.out.println("Answer ques 1: ");
		if (acc2.department == null) {
			System.out.println("Nh??n vi??n n??y ch??a c?? ph??ng ban");
		} else {
			System.out.println("Ph??ng ban c???a nh??n vi??n " + acc2.fullName + " l?? : " + acc2.department.name);
		}

//		Question 2:
//			Ki???m tra account th??? 2
//			N???u kh??ng c?? group th?? s??? in ra text "Nh??n vi??n n??y ch??a c?? group"
//			N???u c?? m???t trong 1 ho???c 2 group th?? s??? in ra text "Group c???a nh??n vi??n
//			n??y l?? Java Fresher, C# Fresher"
//			N???u c?? m???t trong 3 Group th?? s??? in ra text "Nh??n vi??n n??y l?? ng?????i
//			quan tr???ng, tham gia nhi???u group"
//			N???u c?? m???t trong 4 group tr??? l??n th?? s??? in ra text "Nh??n vi??n n??y l??
//			ng?????i h??ng chuy???n, tham gia t???t c??? c??c group"
		System.out.println("\nAnswer ques 2: ");
		if (acc1.groups.length == 0) {
			System.out.println("Nh??n vi??n n??y ch??a c?? group");
		} else if (acc2.groups.length == 1) {
			System.out.println("Group c???a nh??n vi??n n??y l?? " + acc2.groups[0].name);
		} else if (acc2.groups.length == 2) {
			System.out.println("Group c???a nh??n vi??n n??y l?? " + acc2.groups[0].name + acc2.groups[2].name);
		} else if (acc2.groups.length == 3) {
			System.out.println("Nh??n vi??n n??y l?? ng?????i quan tr???ng, tham gia nhi???u group");
		} else if (acc2.groups.length == 4) {
			System.out.println("Nh??n vi??n n??y l?? ng?????i h??ng chuy???n, tham gia t???t c??? c??c group");
		}

//		Question 3:
//			S??? d???ng to??n t??? ternary ????? l??m Question 1
		System.out.println("\nAnswer ques 3: ");
		System.out.println(acc2.groups.length == 0 ? "Nh??n vi??n n??y ch??a c?? ph??ng ban"
				: "Ph??ng ban c???a nh??n vi??n " + acc2.fullName + " l?? : " + acc2.department.name);

//		Question 4:
//			S??? d???ng to??n t??? ternary ????? l??m y??u c???u sau:
//			Ki???m tra Position c???a account th??? 1
//			N???u Position = Dev th?? in ra text "????y l?? Developer"
//			N???u kh??ng ph???i th?? in ra text "Ng?????i n??y kh??ng ph???i l?? Developer"
		System.out.println("\nAnswer ques 4: ");
		System.out.println(
				acc1.position.name == PositionName.DEV ? "????y l?? Developer" : "Ng?????i n??y kh??ng ph???i l?? Developer");

//		Question 5:
//			L???y ra s??? l?????ng account trong nh??m th??? 1 v?? in ra theo format sau:
//			N???u s??? l?????ng account = 1 th?? in ra "Nh??m c?? m???t th??nh vi??n"
//			N???u s??? l?????ng account = 2 th?? in ra "Nh??m c?? hai th??nh vi??n"
//			N???u s??? l?????ng account = 3 th?? in ra "Nh??m c?? ba th??nh vi??n"
//			C??n l???i in ra "Nh??m c?? nhi???u th??nh vi??n"
		System.out.println("\nAnswer ques 5: ");
		int countAccInGroup1 = group1.accounts.length;
		switch (countAccInGroup1) {
		case 1:
			System.out.println("Nh??m c?? m???t th??nh vi??n");
			break;
		case 2:
			System.out.println("Nh??m c?? hai th??nh vi??n");
			break;
		case 3:
			System.out.println("Nh??m c?? ba th??nh vi??n");
			break;
		}

//		Question 6:
//			S??? d???ng switch case ????? l??m l???i Question 2
		System.out.println("\nAnswer ques 6: ");
		int acc2Groups = acc2.groups.length;
		switch (acc2Groups) {
		case 0:
			System.out.println("Nh??n vi??n n??y ch??a c?? group");
			break;
		case 1:
			String ac2GroupName = acc2.groups.toString();
			switch (ac2GroupName) {
			case "Java Fresher":
				System.out.println("Group c???a nh??n vi??n n??y l?? Java Fresher");
				break;
			case "C# Fresher":
				System.out.println("Group c???a nh??n vi??n n??y l?? C# Fresher");
				break;
			}
			break;
		case 2:
			System.out.println("Group c???a nh??n vi??n n??y l?? Java Fresher, C# Fresher");
			break;
		case 3:
			System.out.println("Nh??n vi??n n??y l?? ng?????i quan tr???ng, tham gia nhi???u group");
			break;
		case 4:
			System.out.println("Nh??n vi??n n??y l?? ng?????i h??ng chuy???n, tham gia t???t c??? c??c group");
			break;
		}

//		Question 7:
//			S??? d???ng switch case ????? l??m l???i Question 4
		System.out.println("\nAnswer ques 7: ");

		String positionName = acc1.position.name.toString();
		switch (positionName) {
		case "DEV":
			System.out.println("????y l?? Developer");
			break;
		default:
			System.out.println("Ng?????i n??y kh??ng ph???i l?? Developer");
			break;
		}

//		Question 8:
//			In ra th??ng tin c??c account bao g???m: Email, FullName v?? t??n ph??ng ban c???a
//			h???
		System.out.println("\nAnswer ques 8: ");

		Account[] accArray = { acc1, acc2, acc3, acc4 };
		for (Account account : accArray) {
			System.out.println("AccountID: " + account.id + " Email: " + account.email + " Name: " + account.fullName);
		}

//		Question 9:
//			In ra th??ng tin c??c ph??ng ban bao g???m: id v?? name
		System.out.println("\nAnswer ques 9: ");

		Department[] deptArray = { dept1, dept2, dept3, dept4, dept5 };
		for (Department department : deptArray) {
			System.out.println("DepartmentID: " + department.id + "DepartmentName: " + department.name);
		}

//		Question 10:
//			In ra th??ng tin c??c account bao g???m: Email, FullName v?? t??n ph??ng ban c???a
//			h??? theo ?????nh d???ng nh?? sau:
//			Th??ng tin account th??? 1 l??:
//			Email: NguyenVanA@gmail.com
//			Full name: Nguy???n V??n A
//			Ph??ng ban: Sale
//			Th??ng tin account th??? 2 l??:
//			Email: NguyenVanB@gmail.com
//			Full name: Nguy???n V??n B
//			Ph??ng ban: Marketting
		System.out.println("\nAnswer ques 10: ");
		for (int i = 0; i < accArray.length; i++) {
			System.out.println("Th??ng tin c???a account " + (i + 1) + " l??:");
			System.out.println(
					"AccountID: " + accArray[i].id + " Email: " + accArray[i].email + " Name: " + accArray[i].fullName);
		}

//		Question 11:
//			In ra th??ng tin c??c ph??ng ban bao g???m: id v?? name theo ?????nh d???ng sau:
//			Th??ng tin department th??? 1 l??:
//			Id: 1
//			Name: Sale
//			Th??ng tin department th??? 2 l??:
//			Id: 2
//			Name: Marketing
		System.out.println("\nAnswer ques 11: ");
		for (int j = 0; j < deptArray.length; j++) {
			System.out.println("Th??ng tin c???a department " + (j + 1) + " l??:");
			System.out.println("AccountID: " + deptArray[j].id + "Name: " + deptArray[j].name);
		}

//		Question 12:
//			Ch??? in ra th??ng tin 2 department ?????u ti??n theo ?????nh d???ng nh?? Question 10
		System.out.println("\nAnswer ques 12: ");

		for (int i = 0; i < accArray.length; i++) {
			if (i < 2) {
				System.out.println("Th??ng tin c???a account " + (i + 1) + " l??:");
				System.out.println("AccountID: " + accArray[i].id + " Email: " + accArray[i].email + " Name: "
						+ accArray[i].fullName);
			}
		}
		
//		Question 13:
//			In ra th??ng tin t???t c??? c??c account ngo???i tr??? account th??? 2
		System.out.println("\nAnswer ques 13: ");
		for (int i = 0; i < accArray.length; i++) {
			if (i != 1) {
				System.out.println("Th??ng tin c???a account " + (i + 1) + " l??:");
				System.out.println("AccountID: " + accArray[i].id + " Email: " + accArray[i].email + " Name: "
						+ accArray[i].fullName);
			}
			
		}
		
//		Question 14:
//			In ra th??ng tin t???t c??? c??c account c?? id < 4
		System.out.println("\nAnswer ques 14: ");
		for (int i = 0; i < accArray.length; i++) {
			if (accArray[i].id < 4) {
				System.out.println("Th??ng tin c???a account " + (i + 1) + " l??:");
				System.out.println("AccountID: " + accArray[i].id + " Email: " + accArray[i].email + " Name: "
						+ accArray[i].fullName);
			}
		}
		
//		Question 15:
//			In ra c??c s??? ch???n nh??? h??n ho???c b???ng 20
		System.out.println("\nAnswer ques 15: ");
		for (int i = 0; i <= 20; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
