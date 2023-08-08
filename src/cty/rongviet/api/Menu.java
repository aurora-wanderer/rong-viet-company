package cty.rongviet.api;

import cty.rongviet.enity.NhanVien;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private final Feature ft = new Feature();

    public void show() {
        System.out.println("""
                                    ASSIGNMENT JAVA 1
            +------------------------------------------------------------------+
            |                                                                  |
            |    0. Thoat chuong trinh.                                        |
            |    1. NHAP SACH SACH NHAN VIEN TU BAN PHIM                       |
            |    2. XUAT DANH SACH NHAN VIEN RA MAN HINH                       |
            |    3. TIM VA HIEN THI NHAN VIEN THEO MA NHAP TU BAN PHIM         |
            |    4. XOA NHAN VIEN THEO MA NHAP TU BAN PHIM                     |
            |    5. CAP NHAT THONG TIN NHAN VIEN THEO MA NHAP TU BAN PHIM      |
            |    6. TIM CAC NHAN VIEN THEO KHOANG LUONG NHAP TU BAN PHIM       |
            |    7. SAP XEP NHAN VIEN THEO HO VA TEN                           |
            |    8. SAP XEP NHAN VIEN THEO THU NHAP                            |
            |    9. XUAT 5 NHAN VIEN CO THU NHAP CAO NHAT                      |
            |    10. THEM MOT NHAN VIEN VAO DANH SACH                          |
            |    11. XUAT MOT NHAN VIEN BAT KY THEO MA                         |
            |                                                                  |
            +------------------------------------------------------------------+
            """
        );
        run();
    }

    private void run() {
        Scanner input = new Scanner(System.in);
        String chon;
        do {
            System.out.print("- CHON CHUC NANG: ");
            chon = input.nextLine();
        } while (!chon.matches("^[0-9]+$"));

        int num = Integer.parseInt(chon);

        switch (num) {
            case 0 -> {
                System.out.println("CHUONG TRINH DA KET THUC !");
                System.exit(num);
            }

            case 1 -> {
                System.out.println("NHAP DANH SACH NHAN VIEN!");
                ft.inserts();
            }

            case 2 -> {
                System.out.println("========== THONG TIN DANH SACH ==========");
                System.out.println(ft);
            }

            case 3 -> {
                input = new Scanner(System.in);
                System.out.println("========== NHAP MA NHAN VIEN CAN TIM ==========");
                System.out.print("ID: ");
                NhanVien nv = ft.find(input.nextLine());

                if (nv != null) {
                    System.out.println(nv);
                } else {
                    System.out.println("Khong tim thay !");
                }
            }

            case 4 -> {
                input = new Scanner(System.in);
                System.out.println("========== NHAP MA NHAN VIEN CAN XOA ==========");
                System.out.print("ID: ");

                NhanVien nv = ft.find(input.nextLine());

                if (nv != null) {
                    ft.delete(nv.getID());
                } else {
                    System.out.println("Khong tim thay !");
                }
            }

            case 5 -> {
                input = new Scanner(System.in);

                System.out.println("========== NHAP MA NHAN VIEN CAN CHINH SUA ==========");
                System.out.print("ID: ");

                NhanVien nv = ft.find(input.nextLine());

                if (nv != null) {
                    ft.update(nv.getID());
                } else {
                    System.out.println("Khong tim thay !");
                }
            }

            case 6 -> {
                input = new Scanner(System.in);

                System.out.println("========== NHAP KHOANG LUONG ==========");

                System.out.print("Tu: ");
                double start = input.nextDouble();
                System.out.print("Den: ");
                double end = input.nextDouble();

                System.out.println("\nDanh sach nhan vien theo khoang luong: "
                        + start + " - " + end);
                List<NhanVien> listInRange = ft.findByRange(start, end);

                if (!listInRange.isEmpty()) {
                    System.out.println(listInRange.toString().replaceAll("\\[|\\]|,|, | ,", ""));
                } else {
                    System.out.println("Khong co nhan vien nao thuoc khoang luong tren");
                }
            }

            case 7 -> {
                System.out.println("Danh sach sap xep theo ho va ten: ");
                System.out.println(ft.sortByName());
            }

            case 8 -> {
                System.out.println("Danh sach sap xep theo luong: ");
                System.out.println(ft.sortBySalary());
            }

            case 9 -> {
                System.out.println("Danh sach 5 nhan vien co luong cao nhat: ");
                System.out.println(ft.getHighestSalary(5));
            }

            default -> {
                System.out.println("Khong co chuc nang tren!");
            }
        }

        input = new Scanner(System.in);
        System.out.println("""
                           -- Nhan phim bat ky de tiep tuc chuong trinh -- 
                           (Phim 0 de thoat)
                           """);
        if (input.nextLine().equals("0")) {
            System.out.println("Chuong trinh da ket thuc!");
            System.exit(0);
        }

        show();
    }
}
