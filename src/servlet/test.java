package servlet;

public class test {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="�����ж�����ʣ����в�����(   )��<br>A.������<br>B. ���ɳ���<br>C.ԭ����<br>D. һ����";
		String[] ss=s.split("<br>");
		for (String string : ss) {
			System.out.println(string);
			System.out.println(ss.length);
		}
	}

}
