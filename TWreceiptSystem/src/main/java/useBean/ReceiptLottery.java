
package useBean;

public class ReceiptLottery {
	private String userTime = "";
	private String userNum = "";
	private String theResult = "";

	public void setUserTime(String userTime) {
		this.userTime = userTime;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}

	public String getTheResult() {
		return theResult;
	}

	public void doResult() throws Exception {
		setNumber setNum = new setNumber();
		Compare compare = new Compare();
		try {
			setNum.readNumForDB(userTime);
			String number1 = setNum.getNumber()[0], number2 = setNum.getNumber()[1], number3 = setNum.getNumber()[2],
					special1 = setNum.getNumber()[3], special2 = setNum.getNumber()[4];
			String[] spe6Num = new String[3];

			for (int i = 0; i < 3; i++) {
				spe6Num[i] = setNum.getNumber()[i + 5];
			}

			compare.Arrange(number1, userNum);
			boolean noPrize1 = compare.isNoPrize();
			compare.Arrange(number2, userNum);
			boolean noPrize2 = compare.isNoPrize();
			compare.Arrange(number3, userNum);
			boolean noPrize3 = compare.isNoPrize();

			boolean noPrizeSpe6 = false, noPrizeS1, noPrizeS2;
			theResult = "號碼: <font color='#ff0000'>" + userNum + "</font><br>恭喜中<font color='#ff0000'>";

			for (int i = 0; i < 3; i++) {
				if (spe6Num[i] != "" && spe6Num[i] != null) {
					if (userNum.substring(5, 8).equals(spe6Num[i])) {
						theResult = compare.toMark(userNum, 5, 8);
						theResult += "六獎";
						noPrizeSpe6 = false;
						break;
					} else {
						noPrizeSpe6 = true;
					}
				} else {
					noPrizeSpe6 = true;
					break;
				}
			}
			if (special1.equals(userNum)) {
				theResult += "特別獎";
				noPrizeS1 = false;
			} else {
				noPrizeS1 = true;
			}
			if (special2.equals(userNum)) {
				theResult += "特獎";
				noPrizeS2 = false;
			} else {
				noPrizeS2 = true;
			}

			if (noPrize1 && noPrize2 && noPrize3 && noPrizeSpe6 && noPrizeS1 && noPrizeS2) {
				theResult = "號碼: <font color='#0000FF'>" + userNum + "</font><br><font color='#ff0000'>沒有中獎";
			} else if (noPrizeSpe6 && noPrizeS1 && noPrizeS2) {
				theResult = compare.getResult();
			}
			theResult += "</font>";
		} catch (Exception ex) {
			throw new Exception("此月份資料更新中");
		}
	}
}
