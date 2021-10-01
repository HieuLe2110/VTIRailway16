package Ex4_String;

public class Question9 {
	public static void main(String[] args) {
//		In ra tất cả các group "Java"
		
		String[] groupNames = { "Java Core", "Java Base", "Java Pro" };
		for (String groupName : groupNames) {
		if (groupName.equals("Java")) {
		System.out.println(groupName);
		}
		}
	}
}
