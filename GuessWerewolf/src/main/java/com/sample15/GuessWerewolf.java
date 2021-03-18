
package com.sample15;

import static com.sample15.Character.*;
import java.sql.SQLException;
import java.util.Random;

public class GuessWerewolf {
	private CharacterState state = new CharacterState();
	private stateData sd = new stateData();
	private String result;

	public GuessWerewolf() {
	}

	public String getResult() {
		return result;
	}

	public void toSetCharacter() {
		try {
			sd.linkToDB();
			sd.createTable();
			for (int i = 0; i < 10; i++) {
				doSetCharacter();
				sd.insertData(state.getPlayerStateList());
				state.clearPlayerStateList();
			}
			result = "新增 <font color='#0000ff'>10</font> 筆資料<p>目前 <font color='#ff0000'>" + sd.getMax() + "</font> 筆資料";
			sd.closeState();
		} catch (Exception ex) {
			result = "<font color='#ff0000'>無法新增資料</font>";
		}
	}

	public void toQuery(String player) {
		int playerInt = Integer.parseInt(player);
		try {
			sd.linkToDB();
			if (playerInt != 0) {
				sd.queryData(playerInt);
			} else {
				sd.queryData();
			}
			result = sd.getResult();
		} catch (Exception ex) {
			result = "<font color='#ff0000'>目前無資料</font>";
		}
	}

	public void toUpData(String round) {
		try {
			if (round != "" && round != null) {
				int roundInt = Integer.parseInt(round);
				if (roundInt <= sd.getMax() && roundInt > 0) {
					sd.linkToDB();
					doSetCharacter();
					sd.upData(roundInt, state.getPlayerStateList());
					state.clearPlayerStateList();
					result = sd.getResult();
				} else {
					result = "<font color='#ff0000'>該回合沒有資料</font>";
				}
			} else {
				result = "<font color='#ff0000'>輸入欄位不可空白</font>";
			}
		} catch (SQLException sqlex) {
			result = "<font color='#ff0000'>無法重新分配</font>";
		} catch (Exception ex) {
			result = "<font color='#ff0000'>輸入欄位包含英文或特殊符號</font>";
		}
	}

	public void toDeleteData() {
		try {
			sd.linkToDB();
			sd.deleteData();
			result = "刪除 <font color='#0000ff'>10</font> 筆資料<p>目前 <font color='#ff0000'>" + sd.getMax() + "</font> 筆資料";
		} catch (Exception ex) {
			result = "<font color='#ff0000'>目前無資料</font>";
		}
	}

	public void toDropTable() {
		try {
			sd.linkToDB();
			sd.dropTable();
			result = "<font color='#ff0000'>資料全刪除</font>";
		} catch (Exception ex) {
			result = "<font color='#ff0000'>目前無資料</font>";
		}
	}

	private void doSetCharacter() {
		int characterCode = 0;
		int WEREWOLF_value = 0, PROPHET_value = 0, WITCH_value = 0, HUNTER_value = 0, PEOPLE_value = 0;

		while (state.getPlayerStateList().size() < 10) {
			characterCode = new Random().nextInt(5) + 1;
			switch (characterCode) {
			case 1:
				// import static com.sample.Character.*;
				if (WEREWOLF_value++ < 3) {
					state.setState(WEREWOLF);
				}
				break;
			case 2:
				if (PROPHET_value++ == 0) {
					state.setState(PROPHET);
				}
				break;
			case 3:
				if (WITCH_value++ == 0) {
					state.setState(WITCH);
				}
				break;
			case 4:
				if (HUNTER_value++ == 0) {
					state.setState(HUNTER);
				}
				break;
			case 5:
				if (PEOPLE_value++ < 4) {
					state.setState(PEOPLE);
				}
				break;
			} // switch (characterCode)
		} // while (state.getplayerStateList().size() < 10)
	}
}
