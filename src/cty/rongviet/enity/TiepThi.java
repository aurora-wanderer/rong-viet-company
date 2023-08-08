package cty.rongviet.enity;

import java.util.Scanner;

public class TiepThi extends NhanVien {

    private Double doanhSo;
    private Double hueHong;

    public TiepThi() {
    }

    public TiepThi(
            Double doanhSo,
            Double hueHong,
            String ID,
            String name,
            Double salary) {
        super(ID, name, salary);
        this.doanhSo = doanhSo;
        this.hueHong = hueHong;
    }

    @Override
    public void setInfo() {
        super.setInfo();
        Scanner input = new Scanner(System.in);
        System.out.print("Nhap doanh so: ");
        this.doanhSo = input.nextDouble();
        System.out.print("Nhap hue hong: ");
        this.hueHong = input.nextDouble();
    }

    @Override
    public Double getThuNhap() {
        return (super.getThuNhap() * doanhSo) * hueHong;
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
                formatColumn(6, getDoanhSo()),
                formatColumn(7, getHueHong()),
                formatColumn(8, "")
        );

        return thongTin;
    }

    public Double getDoanhSo() {
        return doanhSo;
    }

    public void setDoanhSo(Double doanhSo) {
        this.doanhSo = doanhSo;
    }

    public Double getHueHong() {
        return hueHong;
    }

    public void setHueHong(Double hueHong) {
        this.hueHong = hueHong;
    }

}
