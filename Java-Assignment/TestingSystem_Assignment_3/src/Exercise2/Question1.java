package Exercise2;

import java.time.LocalDate;

public class Question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account[] listAccount = new Account[5];

		for (int i = 0; i < listAccount.length; i++) {
			listAccount[i] = new Account();
			listAccount[i].email = "Email "+(i + 1);
			listAccount[i].userName = "User name " + (i + 1);
			listAccount[i].fullName = "Full name " + (i + 1);
			listAccount[i].creatDate = LocalDate.now();
		}
		
		for (int i = 0; i < listAccount.length; i++) {
			System.out.println(listAccount[i].email + " " 
							+ listAccount[i].userName + " "
							+ listAccount[i].fullName + " "
							+listAccount[i].creatDate);
		}
	}

}
