/**
 * 
 */
package BaiTap.Tuan5;

/**
 * 
 */
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		CDList ql = new CDList();
		int luaChon = -1;

		do {
			System.out.println("\n╔════════════════════ MENU QUẢN LÝ CD ════════════════════╗");
         	System.out.println("║  1. Thêm CD (tự mở rộng mảng khi đầy)                   ║");
         	System.out.println("║  2. Xóa CD theo mã                                      ║");
         	System.out.println("║  3. Sửa / Cập nhật CD theo mã                           ║");
         	System.out.println("║  4. Tìm kiếm theo mã                                    ║");
         	System.out.println("║  5. Tìm theo tựa - TIỀN TỐ (bên trái)                   ║");
         	System.out.println("║  6. Tìm theo tựa - HẬU TỐ (bên phải)                    ║");
         	System.out.println("║  7. Tìm theo tựa - GẦN GIỐNG (chứa)                     ║");
         	System.out.println("║  8. Hiển thị danh sách                                  ║");
         	System.out.println("║  9. Thống kê                                            ║");
         	System.out.println("║ 10. Sắp xếp giảm dần theo giá thành                     ║");
         	System.out.println("║ 11. Sắp xếp tăng dần theo tựa CD                        ║");
         	System.out.println("║  0. Thoát                                               ║");
         	System.out.println("╚═════════════════════════════════════════════════════════╝");
         	System.out.print("Chọn chức năng: ");

         	try {
         		luaChon = Integer.parseInt(sc.nextLine());
         	} catch (NumberFormatException e) {
         		System.out.println("Vui long nhap so!");
         		continue;
         	}

         	switch (luaChon) {
             	case 1: themCD(ql); break;
             	case 2: xoaCD(ql); break;
             	case 3: capNhatCD(ql); break;
             	case 4: timTheoMa(ql); break;
             	case 5: timTheoTienTo(ql); break;
             	case 6: timTheoHauTo(ql); break;
             	case 7: timGanGiong(ql); break;
             	case 8: ql.hienThiDanhSach(); break;
             	case 9: thongKe(ql); break;
             	case 10: ql.sapXepGiamDanTheoGia(); ql.hienThiDanhSach(); break;
             	case 11: ql.sapXepTangDanTheoTua(); ql.hienThiDanhSach(); break;
             	case 0: System.out.println("Tam biet!"); break;
             	default: System.out.println("Lua chon khong hop le!");
         	}
		} while (luaChon != 0);

		sc.close();
	}

 //cac ham ho tro menu

	static void themCD(CDList ql) {
		try {
			System.out.print("Nhap ma CD (>0): ");
			int ma = Integer.parseInt(sc.nextLine());
			System.out.print("Nhập tựa CD: ");
			String tua = sc.nextLine();
			System.out.print("Nhap so bai hat (>0): ");
			int sbh = Integer.parseInt(sc.nextLine());
         	System.out.print("Nhap gia thanh (>0): ");
         	double gia = Double.parseDouble(sc.nextLine());
         	if (ql.themCD(new CD(ma, tua, sbh, gia)))
         		System.out.println("Them CD thanh cong!");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	static void xoaCD(CDList ql) {
		try {
			System.out.print("Nhap ma CD can xoa: ");
			int ma = Integer.parseInt(sc.nextLine());
			if (ql.xoaCD(ma)) System.out.println("Đa xoa CD ma " + ma);
		} catch (NumberFormatException e) {
			System.out.println("Ma phai la so nguyen!");
		}
	}

	static void capNhatCD(CDList ql) {
		try {
			System.out.print("Nhap ma CD can sua: ");
			int ma = Integer.parseInt(sc.nextLine());
			System.out.print("Tua CD moi: ");
			String tua = sc.nextLine();
			System.out.print("So bai hat moi: ");
			int sbh = Integer.parseInt(sc.nextLine());
			System.out.print("Gia thanh moi: ");
			double gia = Double.parseDouble(sc.nextLine());
			if (ql.capNhatCD(ma, tua, sbh, gia))
				System.out.println("Da cap nhat CD ma " + ma);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	static void timTheoMa(CDList ql) {
		try {
			System.out.print("Nhap ma CD can tim: ");
			int ma = Integer.parseInt(sc.nextLine());
			CD kq = ql.timTheoMa(ma);
			if (kq != null) {
				System.out.println("Tim thay:");
				System.out.println(kq);
			} else System.out.println("Khong co CD ma" + ma);
		} catch (NumberFormatException e) {
			System.out.println("Ma phai la so!");
		}
	}

	static void timTheoTienTo(CDList ql) {
		System.out.print("Nhập tiền tố tựa CD (so khớp BÊN TRÁI): ");
		String tk = sc.nextLine();
		CDList kq = ql.timTheoTienTo(tk);
		System.out.println(" Tim thay " + kq.laySoLuong() + " ket qua (bat dau bang '" + tk + "'):");
		kq.hienThiDanhSach();
	}

	static void timTheoHauTo(CDList ql) {
		System.out.print("Nhập hậu tố tựa CD (so khớp BÊN PHẢI): ");
		String tk = sc.nextLine();
		CDList kq = ql.timTheoHauTo(tk);
		System.out.println(" Tim thay " + kq.laySoLuong() + " ket qua (ket thuc bang '" + tk + "'):");
		kq.hienThiDanhSach();
	}

	static void timGanGiong(CDList ql) {
		System.out.print("Nhập từ khóa (tìm GẦN GIỐNG, chứa ở bất kỳ vị trí): ");
		String tk = sc.nextLine();
		CDList kq = ql.timGanGiong(tk);
		System.out.println("Tim thay " + kq.laySoLuong() + " ket qua (chua '" + tk + "'):");
		kq.hienThiDanhSach();
	}

	static void thongKe(CDList ql) {
		System.out.println("\n====== THỐNG KÊ ======");
		System.out.println("Số lượng CD: " + ql.tinhSoLuongCD());
		System.out.printf("Tổng giá thành: %,.2f VND\n", ql.tinhTongGiaThanh());
		System.out.printf("Giá trung bình: %,.2f VND\n", ql.tinhGiaTrungBinh());
		CD max = ql.timCDDatNhat();
		CD min = ql.timCDReNhat();
		if (max != null) {
			System.out.println("CD đắt nhất:");
			System.out.println("   " + max);
			System.out.println("CD rẻ nhất:");
			System.out.println("   " + min);
		}
	}
}