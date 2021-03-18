
package useBean;

import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AdminPW implements Serializable {
	private String adminPW = "admin";

	public AdminPW() {
	}

	public String getAdminPW() {
		return adminPW;
	}

	public void setAdminPW(String adminPW) {
		this.adminPW = adminPW;
	}

	// 序列化存檔
	public void savePW() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:/Users/leech/git/Demo/TWreceiptSystem/adminPW.save"))) {
			oos.writeObject(adminPW);
		} catch (IOException ex) {
		}
	}

	public void loadPW() {
		// 序列化讀檔
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:/Users/leech/git/Demo/TWreceiptSystem/adminPW.save"))) {
			adminPW = (String) ois.readObject();
		} catch (IOException | ClassNotFoundException ex) {
		}
	}

	public boolean cheakPWfont(String str) {
		boolean boo1 = false;
		boolean boo2 = false;
		boolean boo3 = false;
		boolean boo4 = true;

		for (int i = 0; i < str.length(); i++) {
			if (str.substring(i, i + 1).matches("[A-Z]")) {
				boo1 = true;
				break;
			}
		}
		for (int j = 0; j < str.length(); j++) {
			if (str.substring(j, j + 1).matches("[a-z]")) {
				boo2 = true;
				break;
			}
		}
		for (int k = 0; k < str.length(); k++) {
			if (str.substring(k, k + 1).matches("[0-9]")) {
				boo3 = true;
				break;
			}
		}
		for (int l = 0; l < str.length(); l++) {
			String regEx = "[ _`~!@#$%^&*()+=|{}‘:;‘,\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
			if (str.substring(l, l + 1).matches(regEx)) {
				boo4 = false;
				break;
			}
		}
		return boo1 && boo2 && boo3 && boo4;
	}
}
