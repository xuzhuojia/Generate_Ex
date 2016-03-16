package servlet;

public class test {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="事务有多个性质，其中不包括(   )。<br>A.隔离性<br>B. 不可撤消<br>C.原子性<br>D. 一致性";
		String[] ss=s.split("<br>");
		for (String string : ss) {
			System.out.println(string);
			System.out.println(ss.length);
		}
	}

}
