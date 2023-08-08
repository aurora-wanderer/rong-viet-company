package cty.rongviet.enity;

import java.util.Scanner;

public class NhanVien {

    private String ID;
    private String name;
    private Double salary;

    public NhanVien() {
        setInfo();
    }

    public NhanVien(String ID, String name, Double salary) {
        this.ID = ID;
        this.name = name;
        this.salary = salary;
    }

    public void setInfo() {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap ma nhan vien: ");
        this.ID = input.nextLine();
        System.out.print("Nhap ho ten nhan vien: ");
        this.name = input.nextLine();
        System.out.print("Nhap luong nhan vien: ");
        this.salary = input.nextDouble();
    }

    @Override
    public String toString() {
        String thongTin = """
            |%s|%s|%s|%s|%s|%s|%s|%s|
            |----------------------------------------------------------------------------------------------------------------|
            """.formatted(
                formatColumn(1, this.ID),
                formatColumn(2, this.name),
                formatColumn(3, this.salary),
                formatColumn(4, getThuNhap()),
                formatColumn(5, getThueThuNhap()),
                formatColumn(6, ""),
                formatColumn(7, ""),
                formatColumn(8, "")
        );

        return thongTin;
    }

    public <T> String formatColumn(Integer colIndex, T originalString) {
        //so ki tu cua 1 cot
        int colWidth = 0;

        switch (colIndex) {
            case 1 -> {
                // ID width
                colWidth = 7;
            }
            case 2 -> {
                // Name width
                colWidth = 18;
            }
            case 3, 4, 5, 8 -> {
                // Salary, Income, Income Tax width
                colWidth = 15;
            }

            case 6, 7 -> {
                colWidth = 10;
            }
            default ->
                throw new AssertionError();
        }

        StringBuilder builder = new StringBuilder(originalString + "");

        int len = colWidth - originalString.toString().length();

        if (len > 0) {
            for (int i = 0; i < len; i++) {
                builder.append(" ");
            }
            return builder.toString();
        }

        if (len < 0) {
            return builder.substring(0, colWidth - 3) + "...";
        }

        return builder.toString();
    }

    public Double getThuNhap() {
        return salary;
    }

    public Double getThueThuNhap() {
        if (getThuNhap() > 15000) {
            return 0.12;
        }

        if (getThuNhap() > 9000) {
            return 0.1;
        }

        return 0.0;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
