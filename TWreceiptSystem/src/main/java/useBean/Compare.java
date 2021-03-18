package useBean;

public class Compare {
	private boolean noPrize; // 判斷有無中獎
	private String result; // 結果

	public boolean isNoPrize() {
		return noPrize;
	}

	public String getResult() {
		return result;
	}

	public void Arrange(String str1, String str2) {
		boolean boo[] = new boolean[8];
		for (int i = 0; i < 8; i++) {
			boo[i] = str1.charAt(i) == str2.charAt(i);
		}
		doResult(boo, str2);
	} // public static boolean[] Arrange

	private void doResult(boolean[] boo, String str) {
		if (boo[7] == true && boo[6] == true && boo[5] == true && boo[4] == true && boo[3] == true && boo[2] == true
				&& boo[1] == true && boo[0] == true) {
			result = "號碼: <font color='##ff0000'>" + str + "</font><br>恭喜中<font color='##ff0000'>頭獎";
			noPrize = false;
		} else if (boo[7] == true && boo[6] == true && boo[5] == true && boo[4] == true && boo[3] == true
				&& boo[2] == true && boo[1] == true) {
			result = toMark(str, 1, 8);
			result += "二獎";
			noPrize = false;
		} else if (boo[7] == true && boo[6] == true && boo[5] == true && boo[4] == true && boo[3] == true
				&& boo[2] == true) {
			result = toMark(str, 2, 8);
			result += "三獎";
			noPrize = false;
		} else if (boo[7] == true && boo[6] == true && boo[5] == true && boo[4] == true && boo[3] == true) {
			result = toMark(str, 3, 8);
			result += "四獎";
			noPrize = false;
		} else if (boo[7] == true && boo[6] == true && boo[5] == true && boo[4] == true) {
			result = toMark(str, 4, 8);
			result += "五獎";
			noPrize = false;
		} else if (boo[7] == true && boo[6] == true && boo[5] == true) {
			result = toMark(str, 5, 8);
			result += "六獎";
			noPrize = false;
		} else {
			noPrize = true;
		}
	} // public void Result

	String toMark(String str, int index1, int index2) {
		String result = "號碼: <font color='#0000ff'>" + str.substring(0, index1) + "</font><font color='#ff0000'>"
				+ str.substring(index1, index2) + "</font><br>恭喜中<font color='#ff0000'>";
		return result;
	}
} // public class Compare
