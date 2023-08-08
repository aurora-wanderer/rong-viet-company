package cty.rongviet.api;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

import cty.rongviet.enity.HanhChinh;
import cty.rongviet.enity.NhanVien;
import cty.rongviet.enity.TiepThi;
import cty.rongviet.enity.TruongPhong;

public class Feature {

    private final List<NhanVien> employees = new ArrayList<>();

    private Scanner input = new Scanner(System.in);

    public void inserts() {
        input = new Scanner(System.in);
        System.out.print("""
            ===== CHON CHUC VU CUA NHAN VIEN =====
            0. Thoat Nhap   1. Hanh Chinh   2. Tiep Thi   3. Truong phong
            """
        );

        int role = input.nextInt();

        if (role == 0) {
            System.out.println("Ket thuc nhap danh sach!");
            return;
        }

        System.out.println("===== MOI BAN NHAP THONG TIN =====");
        insert(role);

        inserts();
    }

    private void insert(int role) {
        switch (role) {
            case 1 ->
                employees.add(new HanhChinh());
            case 2 ->
                employees.add(new TiepThi());
            case 3 ->
                employees.add(new TruongPhong());
            default ->
                throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        String thongTinDanhSach = """
            +----------------------------------------------------------------------------------------------------------------+
            |ID     |Name              |Salary(VND)    |Income(VND)    |Income Tax     |Revenue(%)|Sales     |Responsible    |
            |----------------------------------------------------------------------------------------------------------------|
            """;

        for (NhanVien employee : employees) {
            thongTinDanhSach += employee.toString();
        }

        thongTinDanhSach += """
            |       |                  |               |               |               |          |          |               |
            +----------------------------------------------------------------------------------------------------------------+
            """;
        return thongTinDanhSach;
    }

    public NhanVien find(String ID) {
        return employees.stream()
                .filter((emp) -> emp.getID().equals(ID))
                .findFirst()
                .orElse(null);
    }

    public boolean delete(String ID) {
        return employees.removeIf(emp -> emp.getID().equalsIgnoreCase(ID));
    }

    public void update(String ID) {
        int index = employees.indexOf(find(ID));
        NhanVien emp = employees.get(index);
        emp.setInfo();
        employees.set(index, emp);
    }

    public List<NhanVien> sortByName() {
        return employees.stream()
                .sorted(Comparator
                        .comparing(NhanVien::getName))
                .toList();
    }

    public List<NhanVien> sortBySalary() {
        return employees.stream()
                .sorted(Comparator
                        .comparingDouble(NhanVien::getThuNhap))
                .toList();
    }

    public List<NhanVien> getHighestSalary(int limit) {
        return employees.stream()
                .sorted(Comparator
                        .comparingDouble(NhanVien::getThuNhap)
                        .reversed())
                .limit(limit)
                .toList();
    }

    public List<NhanVien> findByRange(Double start, Double end) {
        return employees.stream().filter((employee) -> {
            return employee.getSalary() > start && employee.getSalary() < end;
        }).toList();
    }
}
