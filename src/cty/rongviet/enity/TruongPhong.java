package cty.rongviet.enity;

import java.util.Scanner;

public class TruongPhong extends NhanVien {

    private Double trachNhiem;

    public TruongPhong() {
    }

    public TruongPhong(
            Double trachNhiem,
            String ID,
            String name,
            Double salary) {
        super(ID, name, salary);
        this.trachNhiem = trachNhiem;
    }

    @Override
    public void setInfo() {
        super.setInfo();
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap luong trach nhiem: ");
        this.trachNhiem = input.nextDouble();
    }

    @Override
    public Double getThuNhap() {
        return super.getThuNhap() + trachNhiem;
    }

    @Override
    public String toString() {
        String thongTin = """
            |%s|%s|%s|%s|%s|%s|%s|%s|
            |----------------------------------------------------------------------------------------------------------------|
            """.formatted(
                formatColumn(1, getID()),
                formatColumn(2, getName()),
                formatColumn(3, getSalary()),
                formatColumn(4, getThuNhap()),
                formatColumn(5, getThueThuNhap()),
                formatColumn(6, 0),
                formatColumn(7, 0),
                formatColumn(8, trachNhiem)
        );

        return thongTin;
    }

    public Double getTrachNhiem() {
        return trachNhiem;
    }

    public void setTrachNhiem(Double trachNhiem) {
        this.trachNhiem = trachNhiem;
    }
}
