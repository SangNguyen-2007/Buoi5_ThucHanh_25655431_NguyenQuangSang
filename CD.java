/**
 * 
 */
package BaiTap.Tuan5;

/**
 * 
 */
public class CD {
	//thuoc tinh
	private int maCD;
	private String tuaCD;
	private int soBaiHat;
	private double giaThanh;
	//hang so mdinh
	public static final int MA_CD_MAC_DINH = 999999;
	public static final String TUA_CD_MAC_DINH = "chua xac dinh";
	//Constructor mdinh
	public CD() {
		this.maCD = MA_CD_MAC_DINH;
		this.tuaCD = TUA_CD_MAC_DINH;
		this.soBaiHat = 1;
		this.giaThanh = 1.0;
		}
	public CD(int maCD, String tuaCD, int soBaiHat, double giaThanh) {
		setMaCD(maCD);
		setTuaCD(tuaCD);
		setSoBaiHat(soBaiHat);
		setGiaThanh(giaThanh);
	}

 //getter
	public int getMaCD() { return maCD; }
	public String getTuaCD() { return tuaCD; }
	public int getSoBaiHat() { return soBaiHat; }
	public double getGiaThanh() { return giaThanh; }

 //setter kiem tra rang buoc
	public void setMaCD(int maCD) {
		if (maCD <= 0)
			throw new IllegalArgumentException("Loi: Ma CD phải > 0!");
		this.maCD = maCD;
	}

	public void setTuaCD(String tuaCD) {
		if (tuaCD == null || tuaCD.trim().isEmpty())
			throw new IllegalArgumentException("Loi: Tua CD khong đuoc rong!");
		this.tuaCD = tuaCD;
	}

	public void setSoBaiHat(int soBaiHat) {
		if (soBaiHat <= 0)
			throw new IllegalArgumentException("Loi: So bai hat phai > 0!");
		this.soBaiHat = soBaiHat;
	}

	public void setGiaThanh(double giaThanh) {
		if (giaThanh <= 0)
			throw new IllegalArgumentException("Loi: Gia thanh phai > 0!");
		this.giaThanh = giaThanh;
	}

 //tostring dinh dang
	
	@Override
	public String toString() {
		return String.format(
			"| %-10d | %-25s | %-12d | %-15.2f |",
            maCD, tuaCD, soBaiHat, giaThanh);
	}
}
