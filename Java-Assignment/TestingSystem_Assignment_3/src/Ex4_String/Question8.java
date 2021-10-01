package Ex4_String;

public class Question8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		In ra tất cả các group có chứa chữ "Java"
		
		String[] groupNames = { "Java with VTI", "Cách qua môn gia va", "Học Java có khó không?" };

		for (String groupName : groupNames) {
			if (groupName.contains("Java")) {
				System.out.println(groupName);
			}
		}
	}

}
